package com.iksoo.racer;

public class OutputRacingValues {
    public static void printPositions(int[] carPositions) {
        for (int i = 0; i < carPositions.length; i++) {
            System.out.println(printLine(carPositions[i]));
        }
        printLine();
    }

    public static String printLine(int line) {
        String result = "";
        for (int i = 0; i < line; i++) {
            result += "-";
        }
        return result;
    }

    public static void printLine() {
        System.out.println();
    }
}
