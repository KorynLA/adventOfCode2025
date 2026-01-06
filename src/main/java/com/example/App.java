package com.example;

public class App {

    public static void main(String[] args) {
        DayOne dayOne = new DayOne();
        dayOne.turnLock(50, "inputDayOne.txt");
        DayTwo dayTwo = new DayTwo();
        dayTwo.result("inputDayTwo.txt");
        dayTwo.resultPartTwo("inputDayTwo.txt");
        DayThree dayThree = new DayThree();
        dayThree.result("inputDayThree.txt",1);
        dayThree.result("inputDayThree.txt",2);

    }
}
