package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public static int partOne() {
        var result = 0;
        StringBuilder data = new StringBuilder();
        Util.getScanner(3, 1, false).forEachRemaining(data::append);
        Matcher matcher = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)").matcher(data);
        while (matcher.find()) {
            int firstNumber = Integer
                    .parseInt(matcher.group().substring(matcher.group().indexOf("(") + 1, matcher.group().indexOf(",")));
            int secondNumber = Integer
                    .parseInt(matcher.group().substring(matcher.group().indexOf(",") + 1, matcher.group().indexOf(")")));

            result += Math.multiplyExact(firstNumber, secondNumber);
        }

        return result;
    }

    public static int partTwo() {
        var result = 0;
        StringBuilder data = new StringBuilder();

        Util.getScanner(3, 2, false).forEachRemaining(data::append);
        Matcher matcher = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\)").matcher(data);

        boolean mulInstructions = true;
        while (matcher.find()) {
            if (mulInstructions && matcher.group().contains("mul")) {
                int firstNumber = Integer
                        .parseInt(matcher.group().substring(matcher.group().indexOf("(") + 1, matcher.group().indexOf(",")));
                int secondNumber = Integer
                        .parseInt(matcher.group().substring(matcher.group().indexOf(",") + 1, matcher.group().indexOf(")")));
                result += Math.multiplyExact(firstNumber, secondNumber);
            } else {
                mulInstructions = matcher.group().equals("do()");
            }

        }
        return result;
    }
}
