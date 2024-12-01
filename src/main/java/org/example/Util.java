package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Util {
    private final static String STD_PATH = "src/main/resources/";

    public static Scanner getScanner(int day, int part, boolean test) {
        String filePath = "Day" + day;
        filePath += switch (part) {
            case 1 -> test ? "PartOneTest.txt" : "PartOne.txt";
            case 2 -> test ? "PartTwoTest.txt" : "PartTwo.txt";
            default -> throw new IllegalStateException("Unexpected value: " + part);
        };

        try {
            return new Scanner(new File(STD_PATH + filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
