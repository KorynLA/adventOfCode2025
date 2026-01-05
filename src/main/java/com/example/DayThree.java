package com.example;

import java.util.ArrayList;
import java.util.List;

/*
* Turn on 2 batteries
* Find the largest joltages and sum them
 */
public class DayThree {
    private static List<Integer> getJoltage(List<String> batteries) {
        List<Integer> maxJoltages = new ArrayList<>();
        char[] joltage = new char[2];
        for(String battery : batteries) {
            joltage[0] = 0;
            joltage[1] = 0;
            int index = 0;
            int batteryLength = battery.length();
            while(batteryLength > index) {
                if(battery.charAt(index)-'0' > joltage[0]-'0'
                    && batteryLength-1 > index) {
                    joltage[0] = battery.charAt(index);
                    joltage[1] = 0;
                } else if(battery.charAt(index)-'0' > joltage[1]-'0') {
                    joltage[1] = battery.charAt(index);
                } 
                index++;
            }
            maxJoltages.add(Integer.valueOf((String.valueOf(joltage))));
        }
        return maxJoltages;
    }

    public int result(String fileName) {
        int sum = 0;
        List<String> batteries = FileProcessor.parseByNewLine(fileName);
        List<Integer> maxJoltages = getJoltage(batteries);
        for(int joltage : maxJoltages) {
            sum = sum+joltage;
        }
        System.out.println("Day three: "+ sum);
        return sum;
    }
}
