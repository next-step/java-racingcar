package view;

import domain.Cars;

public class ResultView {

    private final static String BLANK = "";
    private final static String RESULT_MESSAGE = "실행 결과";
    private final static String DISTANCE_BLOCK = "-";

    public static void createResultView(Cars cars, int attemptCount) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(BLANK);

        for (int i = 0; i < attemptCount; i++) {
            cars.makeCarsMove();
            drawDistanceBlock(cars);
            System.out.println(BLANK);
        }
    }

    private static void drawDistanceBlock(Cars cars) {
        for (int i = 0; i < cars.countCars(); i++) {
            int distance = cars.getDistance(i);
            drawConsole(distance);
        }
    }

    private static void drawConsole(int distance) {
        String currentCarDistance = "";
        for (int i = 0; i < distance; i++) {
            currentCarDistance += DISTANCE_BLOCK;
        }
        System.out.println(currentCarDistance);
    }
}
