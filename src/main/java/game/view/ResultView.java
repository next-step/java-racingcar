package game.view;

import game.Car;

import java.util.List;

public class ResultView {

    private final static String RESULT_GUIDE = "실행 결과";
    private final static String LOCATION_CHARACTER = "-";

    public static void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            printCarLocation(car);
        }
    }

    private static void printCarLocation(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < car.location(); i++) {
            stringBuilder.append(LOCATION_CHARACTER);
        }
        System.out.println(stringBuilder);
    }

    public static void finishRound() {
        System.out.println();
    }

    public static void startGame() {
        System.out.println(RESULT_GUIDE);
    }

}
