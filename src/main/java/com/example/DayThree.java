package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.math.BigInteger;
/*
* Turn on 2 batteries from the  battery pack
* Find the largest joltages and sum them
 */
public class DayThree {
    private static List<Integer> getJoltages(List<String> batteryPack) {
        List<Integer> maxJoltages = new ArrayList<>();
        char[] joltage = new char[2];
        for(String battery : batteryPack) {
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

    private static List<Long> getJoltagesPartTwo(List<String> batteryPack) {
        List<Long> maxJoltages = new ArrayList<>();
        Stack<Character> chosenBattery = new Stack<>();
        for(String battery : batteryPack) {
            int index = 1;
            int batteryLength = battery.length();
            char[] joltage = new char[12];
            chosenBattery.push(battery.charAt(0));
            while(batteryLength > index) {
                if(battery.charAt(index)-'0' > chosenBattery.peek()-'0'
                    && batteryLength-index >= 11) {
                        chosenBattery.pop();
                        chosenBattery.push(battery.charAt(index));
                } else if(battery.charAt(index)-'0' > chosenBattery.peek()-'0'
                    && batteryLength-index < 11) {
                        chosenBattery.push(battery.charAt(index));
                    
                } else if(chosenBattery.size() < 11) {
                    chosenBattery.push(battery.charAt(index));
                }
                index++;
            }
            int joltageIndex = joltage.length;
            while(!chosenBattery.isEmpty() && joltageIndex > 0){
                joltageIndex-=1;
                joltage[joltageIndex] = chosenBattery.pop();
            }
            System.out.println(joltage);
            //BigInteger val = BigInteger.valueOf(Long.valueOf((String.valueOf(joltage))));
            maxJoltages.add(Long.valueOf((String.valueOf(joltage))));
        }
        return maxJoltages;
    }

    public Long result(String fileName) {
        Long sum = 0L;
        List<String> batteryPack = FileProcessor.parseByNewLine(fileName);
        List<Long> maxJoltages = getJoltagesPartTwo(batteryPack);
        for(Long joltage : maxJoltages) {
            sum = sum+joltage;
        }
        System.out.println("Day three: "+ sum);
        return sum;
    }
}
