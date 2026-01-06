package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
* Turn on 2 batteries from the  battery pack
* Find the largest joltages and sum them
 */
public class DayThree {
    private static List<Long> getJoltages(List<String> batteryPack) {
        List<Long> maxJoltages = new ArrayList<>();
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
            maxJoltages.add(Long.valueOf((String.valueOf(joltage))));
        }
        return maxJoltages;
    }

    private static List<Long> getJoltagesPartTwo(List<String> batteryPack) {
        List<Long> maxJoltages = new ArrayList<>();
        Stack<Character> chosenBattery = new Stack<>();
        int batteries = 12;
        for(String battery : batteryPack) {
            int index = 1;
            int batteryLength = battery.length();
            char[] joltage = new char[batteries];
            chosenBattery.push(battery.charAt(0));
            while(batteryLength > index) {
                if(battery.charAt(index)-'0' > chosenBattery.peek()-'0') { 
                    while(!chosenBattery.isEmpty() && battery.charAt(index)-'0' > chosenBattery.peek()-'0' && 
                        batteryLength-index > batteries-chosenBattery.size()) {
                            chosenBattery.pop();
                        }
                        chosenBattery.push(battery.charAt(index));
                }  else if(chosenBattery.size() < batteries) {
                    chosenBattery.push(battery.charAt(index));
                }
                index++;
            }

            int joltageIndex = joltage.length;
            while(!chosenBattery.isEmpty() && joltageIndex > 0){
                joltageIndex-=1;
                joltage[joltageIndex] = chosenBattery.pop();
            }
            maxJoltages.add(Long.valueOf((String.valueOf(joltage))));
        }
        return maxJoltages;
    }

    public Long result(String fileName, int part) {
        Long sum = 0L;
        List<String> batteryPack = FileProcessor.parseByNewLine(fileName);
        List<Long> maxJoltages;
        if(part == 1) {
            maxJoltages = getJoltages(batteryPack);
        } else {
            maxJoltages = getJoltagesPartTwo(batteryPack);
        }
        for(Long joltage : maxJoltages) {
            sum+=joltage;
        }
        System.out.println("Day three part " + part +": "+ sum);
        return sum;
    }
}
