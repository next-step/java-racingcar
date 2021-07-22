package racingcar.view;

import racingcar.vehicle.Cars;

public class ResultView {

    private static final char PRINT_FLAG = '-';

    public static void pirntProgressBoard(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(getDistanceString(cars.getDistance(i)));
        }
        System.out.println("==========");
    }

    private static String getDistanceString(int distance) {
        StringBuilder printDistance = new StringBuilder();

        for (int i = 0; i < distance; i++) {
            printDistance.append(PRINT_FLAG);
        }

        return printDistance.toString();
    }
}
