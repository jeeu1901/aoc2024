package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Day1 {

    public static int partOne() {

        AtomicInteger result = new AtomicInteger();

        var scanner = Util.getScanner(1, 1, false);

        var leftList = new ArrayList<Integer>();
        var rightList = new ArrayList<Integer>();

        while(scanner.hasNextLine()) {
            var rows = scanner.nextLine().split(" {3}");

            leftList.add(Integer.valueOf(rows[0]));
            rightList.add(Integer.valueOf(rows[1]));
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        IntStream.range(0, leftList.size()).forEach(i -> {
            result.addAndGet(getDifference(leftList.get(i), rightList.get(i)));
        });
        return result.get();
    }

    public static int getDifference(int left, int right) {
        return Math.abs(left - right);
    }


    public static int partTwo() {

        AtomicInteger result = new AtomicInteger();
        var scanner = Util.getScanner(1, 2, false);
        var leftList = new ArrayList<Integer>();
        var rightList = new ArrayList<Integer>();

        while (scanner.hasNextLine()) {
            var rows = scanner.nextLine().split(" {3}");
            leftList.add(Integer.valueOf(rows[0]));
            rightList.add(Integer.valueOf(rows[1]));
        }

        leftList.forEach(l -> {
            result.addAndGet((l * getSimilarity(l, rightList)));
        });

        return result.get();

    }

    public static int getSimilarity(int left, List<Integer> rightList) {
        return (int) rightList.stream().filter(l -> l == left).count();
    }
}
