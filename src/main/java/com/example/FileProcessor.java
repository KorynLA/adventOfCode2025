package com.example;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FileProcessor {
    private FileProcessor() {
        throw new AssertionError("FileProcessor class cannot be instantiated");
    }
    public static List<String> parseByComma(String fileName) {
        StringBuilder lines = new StringBuilder();
        String input = "";
        char ch;
        try {
            FileReader fr = new FileReader("src/main/java/com/example/"+fileName);
            while(fr.ready()) {
                ch = (char)fr.read();
                if(ch != '\n') {
                    lines.append(ch);
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        input = lines.toString();
        return Arrays.asList(input.split("[,]\\s*"));
    }
    
    public static List<String> parseByNewLine(String fileName) {
        Path filePath = Paths.get("src/main/java/com/example/"+fileName);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(filePath);
         } catch(IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
