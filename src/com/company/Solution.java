package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;

import java.util.*;

public class Solution {

    private static ContainerFactory orderedKeyFactory;
    private static JSONArray docs;
    private static JSONParser parser;

    public static void main(String [] args) {

        Solution.bootstrap();

        Scanner sc = new Scanner(System.in);
        String line, op, doc;
        int spaceIdx;
        while(true) {
            line = sc.hasNextLine() ? sc.nextLine().trim() : "";
            spaceIdx = line.indexOf(" ");
            if (line.length() == 0 || spaceIdx < 0) {
                continue;
            }
            op = line.substring(0, spaceIdx).toLowerCase();
            doc = line.substring(spaceIdx).trim();
            switch (op) {
                case "add":
                    Solution.addJson(doc);
                    break;
                case "get":
                    Solution.getJson(doc);
                    break;
                case "delete":
                    Solution.deleteJson(doc);
                    break;
            }
        }
    }

    private static void bootstrap() {

        Solution.orderedKeyFactory = new ContainerFactory()
        {
            public List creatArrayContainer() {
                return new LinkedList();
            }

            public Map createObjectContainer() {
                return new LinkedHashMap();
            }
        };

        Solution.docs = new JSONArray();
        Solution.parser = new JSONParser();
    }

    private static void addJson(String doc) {
        try {
            Solution.docs.add((LinkedHashMap) Solution.parser.parse(doc, Solution.orderedKeyFactory));
        } catch (Exception e) {
            //Some handling logic
        }
    }

    private static void getJson(String docStr) {

        try {
            Map queryDoc = (Map) Solution.parser.parse(docStr, Solution.orderedKeyFactory);
            for (Object doc : Solution.docs) {
                if (Solution.matches((Map)doc, queryDoc)) {
                    System.out.println(JSONValue.toJSONString(doc) );
                }
            }
        } catch (Exception e) {
            //Some handling logic
        }

    }

    private static void deleteJson(String docStr) {
        try {
            JSONArray newDocs = new JSONArray();
            Map queryDoc = (Map) Solution.parser.parse(docStr, Solution.orderedKeyFactory);
            for (Object doc : Solution.docs) {
                if (Solution.matches((Map)doc, queryDoc)) {
                    continue;
                }
                newDocs.add(doc);
            }
            Solution.docs = newDocs;
        } catch (Exception e) {
            //Some handling logic
        }
    }

    private static boolean matches(Map base, Map query) {
        if (base.isEmpty() && !query.isEmpty()) {
            return false;
        }
        Iterator itr = query.keySet().iterator();
        boolean isMatchSoFar = true;
        while(itr.hasNext()) {
            String key = itr.next().toString();
            String classNameQ = query.get(key).getClass().getSimpleName();
            if (!base.containsKey(key) || !isMatchSoFar) {
                return false;
            } else if (!classNameQ.equals(base.get(key).getClass().getSimpleName()) || !isMatchSoFar) {
                return false;
            } else if (classNameQ.equals(LinkedHashMap.class.getSimpleName()) && isMatchSoFar) {
                isMatchSoFar = isMatchSoFar && Solution.matches((Map)base.get(key), (Map)query.get(key));
            } else if (classNameQ.equals(LinkedList.class.getSimpleName()) && isMatchSoFar) {
                //List of Map is not handled
                isMatchSoFar = isMatchSoFar && Solution.checkForLinkedArrayMatch((LinkedList)base.get(key), (LinkedList)query.get(key));
            } else if (!query.get(key).equals(base.get(key)) || !isMatchSoFar) {
                return false;
            }
        }
        return isMatchSoFar;
    }

    private static boolean checkForLinkedArrayMatch(LinkedList base, LinkedList query) {
        boolean isMatchSoFar = true, isItemPresent;
        for(Object q : query) {
            isItemPresent = false;
            if (q instanceof LinkedHashMap) {
                for (Object el : base) {
                    if (el instanceof LinkedHashMap) {
                        isItemPresent = isItemPresent || Solution.matches((Map)el, (Map)q);
                    } if (isItemPresent) {
                        break;
                    }
                }
                isMatchSoFar = isMatchSoFar && isItemPresent;
            } else if (q instanceof LinkedList) {
                for (Object el : base) {
                    if (el instanceof LinkedList) {
                        isItemPresent = isItemPresent ||
                                Solution.checkForLinkedArrayMatch((LinkedList)el, (LinkedList)q);
                    } if (isItemPresent) {
                        break;
                    }
                }
            } else {
                isItemPresent = base.contains(q);
            }
            isMatchSoFar = isMatchSoFar && isItemPresent;
            if(!isMatchSoFar) {
                break;
            }
        }
        return isMatchSoFar;
    }
}
