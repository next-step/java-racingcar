package com.java.jaeheon.step2;

public class ResultView {
    private static final String DISTANCE_SYMBOL = "-";

    public static void resultViewDistanceByCar(Car cars) {
        for (int i = 0; i < cars.getDistance(); i++) {
            System.out.print(DISTANCE_SYMBOL);
        }
        toTheNextLine();
    }

    public static void toTheNextLine() {
        System.out.println();
    }

}
