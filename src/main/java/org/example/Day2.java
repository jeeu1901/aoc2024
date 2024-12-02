package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

    public static int partOne() {

        var scanner = Util.getScanner(2, 1, false);
        var result = 0;
        
        while(scanner.hasNextLine()) {
            List<Integer> report = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toCollection(ArrayList::new));
            
            if(isSafe(report)) {
                result++;
            }
            
        }

        return result;
    }

    public static int partTwo() {
        var scanner = Util.getScanner(2, 1, false);
        var result = 0;

        while(scanner.hasNextLine()) {
            List<Integer> report = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toCollection(ArrayList::new));

            if (isSafePartTwo(report)) {
                result++;
            }
        }


        return result;
    }

    public static boolean isSafePartTwo(List<Integer> report) {
        if (isSafe(report)) {
            return true;
        }

        for (int i = 0; i < report.size(); i++) {
            List<Integer> modifiedLevels = new ArrayList<>(report);
            modifiedLevels.remove(i);

            if (isSafe(modifiedLevels)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSafe(List<Integer> report) {
        boolean isDecreasing = true;
        boolean isIncreasing = true;

        for (int i = 0; i < report.size() - 1; i++) {
            int current = report.get(i);
            int next = report.get(i + 1);

            if (current >= next) {
                isIncreasing = false;
            }
            if (current <= next) {
                isDecreasing = false;
            }

            int difference = Math.abs(current - next);
            if (difference < 1 || difference > 3) {
                return false;
            }
        }

        return isIncreasing || isDecreasing;
    }

}
