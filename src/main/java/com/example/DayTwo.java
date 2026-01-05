package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Input we get is in a single line & seperated by commas, while the RANGE is seperated
 * by dash.
 * The invalid IDs have numbers that repeat twice - 
 * i.e. 11, 1188511885, 6464
 * 
 * Part 2
 * The invalid IDs have numbers that are repeated more than twice
 * i.e. 12121212, 11111111
 */
public class DayTwo {
    public static HashSet<String> invalidId = new HashSet<>();

    public static String[] getRange(String range) {
        String[] foundRange = new String[2];
        String[] seperatedRange = range.split("-");

        foundRange[0]=seperatedRange[0];
        foundRange[1]=seperatedRange[1];

        return foundRange;
    }
    public static List<Long> getInvalidProductIds(String[] range) {
        List<Long> products = new ArrayList<>();
        
        for(Long j=Long.valueOf(range[0]); j <= Long.valueOf(range[1]); j++) {
            String numVal = String.valueOf(j);
            if(invalidId.contains(numVal)) {
                products.add(j);
                continue;
            }
            int size = numVal.length();
            if(size%2 == 0) {
                if(numVal.substring(0, size/2).equals(numVal.substring((size/2)))) {
                    products.add(j);
                    invalidId.add(numVal);
                }
            }
        }

        return products;
    }

    public static List<Long> getInvalidProductIdsPartTwo(String[] range) {
        ArrayList<Long> products = new ArrayList<>();

        for(Long j=Long.valueOf(range[0]); j <= Long.valueOf(range[1]); j++) {
            String numVal = String.valueOf(j);
            if(invalidId.contains(numVal)) {
                products.add(j);
                continue;
            }
            int size = numVal.length();
            int divisor = size/2;
            if(size == 2) {
                String compareString = numVal.substring(0, 1);
                if(compareString.equals(numVal.substring(1, 2))) {
                    products.add(j);
                    invalidId.add(numVal);
                }
                continue;
            }
            dfs(numVal, j, size, divisor, products);
        }

        return products;
    }

    public static void dfs(String numVal, long num, int size, int divisor, ArrayList<Long> found) {
        if(divisor <= 0) {
            return ;
        }
        if(invalidId.contains(numVal)) {
            return ;
        }
        Boolean equal = true;
        String compareString = "";
        if(size%divisor == 0) {
            compareString = numVal.substring(0, divisor);
            int i = 2;
            while(size >= divisor*i) {
                if(!compareString.equals(numVal.substring(((divisor*(i-1))), divisor*i))) {
                    equal = false;
                    break;
                }
                i++;
            }
        } else {
            equal = false;
        }
        if(equal) {
            found.add(num);
            invalidId.add(numVal);
        }

        dfs(numVal, num, size, divisor-=1, found);
    }

    public long result(String fileName) {
        List<String> ranges = FileProcessor.parseByComma(fileName);
        List<Long> invalidProductIds = new ArrayList<>();
        for(int i=0; i < ranges.size(); i++) {
            String[] range = getRange(ranges.get(i));
            invalidProductIds.addAll(getInvalidProductIds(range));
        }

        long invalidProductIdSum = 0;
        for(Long id : invalidProductIds) {
            invalidProductIdSum+=id;
        }

        System.out.println("Day two part 1: " + invalidProductIdSum);
        return invalidProductIdSum;
    }

    public long resultPartTwo(String fileName) {
        List<String> ranges = FileProcessor.parseByComma(fileName);
        List<Long> invalidProductIds = new ArrayList<>();
        for(int i=0; i < ranges.size(); i++) {
            String[] range = getRange(ranges.get(i));
            invalidProductIds.addAll(getInvalidProductIdsPartTwo(range));
        }

        long invalidProductIdSum = 0;
        for(Long id : invalidProductIds) {
            invalidProductIdSum+=id;
        }

        System.out.println("Day two part 2: " + invalidProductIdSum);
        return invalidProductIdSum;
    }
}

