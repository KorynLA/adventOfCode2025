package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Path filePath = Paths.get("src/main/java/com/example/inputDayOne.txt");
        List<String> lines = new ArrayList<>();
        try {
        lines = Files.readAllLines(filePath);
        } catch(IOException e) {
            e.printStackTrace();
        }

        DayOne dayOne = new DayOne();
        System.out.println(dayOne.turnLock(50, lines));
    }
}
