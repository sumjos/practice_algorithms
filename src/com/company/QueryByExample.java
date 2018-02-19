package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/*public class QueryByExample {

    private static List<JsonElement> jsonArray = new ArrayList();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner in = new Scanner(System.in);
        while(true){
            //String line = in.nextLine().trim();
            String line = br.readLine();
            if (line == null || line.trim().length() == 0)
                continue;
            line = line.trim();
            int spaceIdx = line.indexOf(" ");
            String command = line.substring(0, spaceIdx);
            String json = line.substring(spaceIdx);

            if(command.equals("add")){
                add(json);
            } else if(command.equals("get")){
                get(json).forEach(System.out::println);
            } else if(command.equals("delete")){
                delete(json);
            }
        }
    }

    private static void add(final String json){
        JsonParser jsonParser = new JsonParser();
        try {
            JsonElement element = jsonParser.parse(json);
            jsonArray.add(element.getAsJsonObject());
        } catch (Exception e) {
            //Exception handling piece
        }

    }

    private static List<JsonElement> get(final String json){
        JsonParser jsonParser = new JsonParser();
        try {
            JsonElement element = jsonParser.parse(json);
            //JsonObject jsonObject = element.getAsJsonObject();
            return jsonArray.stream()
                    .filter(j ->  matches(element, j))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            //Exception handling piece
            return null;
        }
    }

    private static void delete(final String json){
        JsonParser jsonParser = new JsonParser();
        try {
            JsonElement element = jsonParser.parse(json);
            jsonArray = jsonArray.stream()
                    .filter(j -> !matches(element, j))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            //Exception handling piece
        }
    }

    private static boolean matches(final JsonElement queryElement, final JsonElement baseElement){
        if((queryElement == null || queryElement.isJsonNull())) {
            return true;
        } else if (baseElement == null || baseElement.isJsonNull()) {
            return false;
        } else if(baseElement.isJsonPrimitive() && queryElement.isJsonPrimitive()){
            return baseElement.equals(queryElement);
        } else if (baseElement.isJsonObject() && queryElement.isJsonObject()) {
            final JsonObject bElObj = baseElement.getAsJsonObject();
            final Set<Map.Entry<String, JsonElement>> entrySet = queryElement.getAsJsonObject().entrySet();
            return entrySet.parallelStream().allMatch(entry -> matches(entry.getValue(), bElObj.get(entry.getKey())));
        } else if(queryElement.isJsonArray() && baseElement.isJsonArray()) {
            //final List<JsonElement> queryList = queryElement.getAsJsonArray();
            final JsonArray baseList = baseElement.getAsJsonArray();
            final JsonArray queryList = queryElement.getAsJsonArray();
            //if(queryList.size() == 1 && baseList.size() == 1) {
              //  return queryList.get(0).equals(q)
           // }
            //return queryList.stream().filter(q ->  baseList.stream()
              //      .noneMatch(b -> matches((JsonElement) q, (JsonElement) b))).count() == 0;
            //return queryList.stream().allMatch(q ->  baseList.stream()
              //      .anyMatch(b -> matches((JsonElement) q, (JsonElement)b)));
            //Spliterator<JsonElement> q1 = queryElement.getAsJsonArray().spliterator();
            //Spliterator<JsonElement> q2 = q1.trySplit();
            //List <JsonElement> temp2 = Arrays.asList(baseElement.getAsJsonArray());
            for(JsonElement q : queryList) {
                boolean isFound = false;
                for(JsonElement b : baseList) {
                    isFound = isFound || matches(q, b);
                    if(isFound)
                        break;
                }
                if(!isFound)
                    return false;
            }
            return true;
        }
        return false;
    }
}*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class QueryByExample {

    private static List<JsonElement> jsonArray = new ArrayList<>();
    private static final JsonParser jsonParser = new JsonParser();

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = br.readLine();
            int spaceIndex = line.indexOf(" ");
            String command = line.substring(0, spaceIndex).replaceAll("[^0-9a-zA-Z]+", "");
            String json = line.substring(spaceIndex);
            switch (command) {
                case "add":
                    add(json);
                    break;
                case "get":
                    get(json);
                    break;
                case "delete":
                    delete(json);
                    break;
            }
        }
    }

    private static void add(final String json){
        try {
            JsonElement element = jsonParser.parse(json);
            jsonArray.add(element);
        } catch (Exception e) {
            //Exception handling piece
        }

    }

    private static void get(final String queryJson){
        try {
            JsonElement queryElement = jsonParser.parse(queryJson);
            jsonArray.stream()
                    .filter(baseElement ->  matches(queryElement, baseElement))
                    .forEach(System.out::println);
        } catch (Exception e) {
            //Exception handling piece
        }
    }

    private static void delete(final String queryJson){
        try {
            JsonElement queryElement = jsonParser.parse(queryJson);
            jsonArray = jsonArray.stream()
                    .filter(baseElement -> !matches(queryElement, baseElement))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            //Exception handling piece
        }
    }

    private static boolean matches(final JsonElement queryElement, final JsonElement baseElement){
        if((queryElement == null || queryElement.isJsonNull())) {
            return true;
        } else if (baseElement == null || baseElement.isJsonNull()) {
            return false;
        } else if(baseElement.isJsonPrimitive() && queryElement.isJsonPrimitive()){
            return baseElement.equals(queryElement);
        } else if (baseElement.isJsonObject() && queryElement.isJsonObject()) {
            final JsonObject bElObj = baseElement.getAsJsonObject();
            final Set<Map.Entry<String, JsonElement>> entrySet = queryElement.getAsJsonObject().entrySet();
            return entrySet.stream().allMatch(entry -> matches(entry.getValue(), bElObj.get(entry.getKey())));
        } else if(queryElement.isJsonArray() && baseElement.isJsonArray()) {
            final JsonArray queryList = queryElement.getAsJsonArray();
            final JsonArray baseList = baseElement.getAsJsonArray();
            return matchesJsonArrayParallel(queryList, baseList);
        }
        return false;
    }

    private static boolean matchesJsonArrayParallel(final JsonArray queryList, final JsonArray baseList) {
        final HashSet<JsonElement> qList = new HashSet<>();
        queryList.iterator().forEachRemaining(qList::add);
        final HashSet<JsonElement> bList = new HashSet<>();
        baseList.iterator().forEachRemaining(bList::add);
        return qList.parallelStream().allMatch(q -> bList.parallelStream().anyMatch(b -> matches(q, b)));
    }
}