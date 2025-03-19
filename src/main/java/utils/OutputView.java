package utils;

import car.Car;

import java.util.List;

public class OutputView {
    private static final String CAR_POSITION_MARK = "-";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String COLON = " : ";

    public static void displayRoundResult(List<Car> cars) {
        cars.forEach(car -> printCarPosition(car.getName(), car.getPosition()));
        println();
    }

    public static void displayResultMessage() {
        println(RESULT_MESSAGE);
    }

    private static void printCarPosition(String carName, int count) {
        println(carName + COLON + CAR_POSITION_MARK.repeat(count));
    }

    private static void println(String string) {
        System.out.println(string);
    }

    private static void println() {
        System.out.println();
    }
}
