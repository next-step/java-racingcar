package com.racingcar.view;

public class ResultView {
    public static void draw(int[][] result) {
        System.out.println("실행 결과");

        for (int i = 0; i < result.length; i++) {
            drawOneRound(result[i]);
        }
    }

    private static void drawOneRound(int[] distances) {
        for (int i = 0; i < distances.length; i++) {
            drawCar(distances[i]);
        }
    }

    private static void drawCar(int distance) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < distance; i++) {
            builder.append("-");
        }

        System.out.println(builder.toString());
    }
}
