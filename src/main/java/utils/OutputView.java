package utils;

import car.Car;

import java.util.List;

public class OutputView {
    private static final String CAR_POSITION_MARK = "-";
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void displayRoundResult(List<Car> cars) {
        cars.forEach(car -> printCarPosition(car.getPosition()));
        println();
    }

    public static void displayResultMessage() {
        println(RESULT_MESSAGE);
    }

    private static void printCarPosition(int count) {
        println(CAR_POSITION_MARK.repeat(count));
    }

    private static void println(String string) {
        System.out.println(string);
    }

    private static void println() {
        System.out.println();
    }
}
