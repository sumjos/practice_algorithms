package com.company.algorithms;

import java.util.*;

public class PriorityQueues {

    public static void main(String [] args) {
        //PriorityQueues.basicQueueOperations();

        //long op = PriorityQueues.jesseCookies();
        //System.out.println(op + " operations done!");

        PriorityQueues.runningMedian();

    }

    public static void basicQueueOperations() {
        Scanner sc = new Scanner(System.in);
        long queryCount = sc.nextLong();
        PriorityQueue<Long> pq = new PriorityQueue<Long>(11, PriorityQueues.valComparator);
        sc.nextLine();
        while(queryCount > 0) {
            String linEl[] = sc.nextLine().trim().split("\\s");
            switch(linEl[0].trim()) {
                case "1":
                    pq.add(Long.parseLong(linEl[1].trim()));
                    break;
                case "2":
                    pq.remove(Long.parseLong(linEl[1].trim()));
                    break;
                case "3":
                    System.out.println(pq.peek());
                    break;
            }
            queryCount --;
        }
    }

    public static long jesseCookies() {
        Scanner sc = new Scanner(System.in);
        String line;
        line = sc.nextLine();
        long numCookies = Long.valueOf(line.split("\\s")[0].trim());
        long sweetness = Long.valueOf(line.split("\\s")[1].trim());
        String nums[] = sc.nextLine().split("\\s");

        PriorityQueue<Long> pq = new PriorityQueue<Long>(11, PriorityQueues.valComparator);
        for (String num : nums) {
            pq.add(Long.parseLong(num.trim()));
        }

        if (pq.size() <= 1 && pq.peek() < sweetness) {
            return -1;
        }

        long op = 0;
        while(pq.peek() < sweetness && pq.size() > 1) {

            long c1 = pq.poll();
            long c2 = pq.poll();
            pq.add(c1 + 2*c2);
            op++;
            if (pq.size() <= 1 && pq.peek() < sweetness) {
                return -1;
            }
        }
        return op;
    }

    public static void runningMedian() {
        Scanner sc = new Scanner(System.in);
        int numCount = Integer.valueOf(sc.nextLine().trim());

        ArrayList<Long> list = new ArrayList<Long>();
        while(list.size() < numCount) {
            int itr;
            long val = Long.parseLong(sc.nextLine().trim());
            for (itr = 0; itr < list.size(); itr++) {
                if (list.get(itr) > val) {
                    break;
                }
            }
            list.add(itr, val);
            int count = list.size();
            double median;
            median = count%2 == 0 ? (double)(list.get(count/2 - 1) + list.get(count/2))/2 : (double)list.get((count + 1)/2 - 1);
            System.out.println(median);
        }

        //Timed out
        /*List<Long> ls = new ArrayList<Long>();
        long count = 1;
        while(count <= numCount) {
            ls.add(Long.parseLong(sc.nextLine().trim()));
            Collections.sort(ls);
            double val = count%2 == 0 ? (double)(ls.get((int)count/2 - 1) + ls.get((int)count/2))/2 : ls.get((int)(count + 1)/2 - 1);
            System.out.println(val);
            count++;
        }*/

        //Timed out
        /*PriorityQueue<Long> pq = new PriorityQueue<Long>(11, PriorityQueues.valComparator);
        long count = 1;
        long val1 = Long.MIN_VALUE, val2 = Long.MIN_VALUE;
        long innerItr = 1;
        while(count <= numCount) {
            pq.add(Long.parseLong(sc.nextLine().trim()));
            innerItr = 1;
            PriorityQueue<Long> pqTemp = new PriorityQueue<Long>(pq);
            while(innerItr <= (long)(count/2) + 1 && innerItr <= pq.size()) {
                val1 = val2;
                val2 = pqTemp.poll();
                innerItr++;
            }
            double median = (count%2 == 0) ? (double)(val1 + val2)/2 : val2;
            System.out.println(median);
            count++;
        }*/
    }

    private static Comparator<Long> valComparator = new Comparator<Long>() {
        @Override
        public int compare(Long o1, Long o2) {
            return o1.compareTo(o2);
        }
    };
}
