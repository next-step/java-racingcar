package view;

import domain.Cars;

public class ResultView {

    public static final String RESULT_HEAD_TEXT = "\n실행결과";
    public static final String PRINT_WINNER_FORMAT = "최종 우승자: %s\n";

    public static void printResultHead() {
        System.out.println(RESULT_HEAD_TEXT);
    }

    public static void printCars(Cars cars) {
        System.out.println(cars.convertCarsStatus());
    }

    public static void printWinners(String winners) {
        System.out.printf(PRINT_WINNER_FORMAT, winners);
    }
}
