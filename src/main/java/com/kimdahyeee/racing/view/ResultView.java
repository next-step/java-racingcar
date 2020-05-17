package com.kimdahyeee.racing.view;

import java.util.List;

public class ResultView {
    private static final String CAR_POSITION_DISPLAY = "-";

    public static void printHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void print(List<Integer> carPositions) {
        for (Integer carPosition : carPositions) {
            printByOneCar(carPosition);
            System.out.println();
        }
    }

    private static void printByOneCar(Integer position) {
        for (int i = 0; i < position; i++) {
            System.out.print(CAR_POSITION_DISPLAY);
        }
    }

}
