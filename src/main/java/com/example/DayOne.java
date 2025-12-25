package com.example;

import java.util.List;

public class DayOne {
    public int turnLock(int start, List<String> turns) {
        int location = 0;
        int counter = 0;
        
        for(int i=0; i < turns.size(); i++) {
            String turn = turns.get(i).trim();
            char movement = turn.charAt(0);
            Integer val = Integer.parseInt(turn.substring(1));

            if(movement == 'L') {
                location = start-val;
            } else {
                location = start+val;
            }
        
            while (location < 0) {
                location = 99+location+1;
            }
            while(location > 99) {
                location = location-99-1;
            }

            if(location == 0) {
                counter++;
            }
            start = location;
        }

        return counter;
      }
}
