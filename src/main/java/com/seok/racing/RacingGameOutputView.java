package com.seok.racing;

import java.util.Arrays;
import java.util.Collections;

public class RacingGameOutputView {

    private final static String CAR_LOCATION_SYMBOL = "-";

    public static void printRecords(int[][] records) {
        int[] result = new int[records[0].length];
        for (int[] record : records) {
            Arrays.setAll(result, idx -> result[idx] + record[idx]);
            Arrays.stream(result)
                    .mapToObj(location -> String.join("", Collections.nCopies(location, CAR_LOCATION_SYMBOL)))
                    .forEach(System.out::println);
            System.out.println("next");
        }


    }
}
