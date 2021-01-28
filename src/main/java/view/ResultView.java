package view;

import domain.Car;

import java.util.ArrayList;

public class ResultView {
    private static final String BEFORE_START_SIGN = "실행 결과";
    private static final String STATE_CHARACTER = "-";
    private static final String RESULT_SENTENCE = "최종 우승자: ";

    public static void printStartSign() {
        System.out.println(BEFORE_START_SIGN);
    }

    public static void printCars(ArrayList<Car> cars) {
        for (Car car : cars) {
            printEachCar(car);
        }
        System.out.println();
    }

    public static void printEachCar(Car car) {
        System.out.print(car.getName()+" : ");
        for (int i=0; i<car.getStatus(); i++) {
            System.out.print(STATE_CHARACTER);
        }
        System.out.println();
    }

    public static void printWinners(ArrayList<String> winners) {
        System.out.println(RESULT_SENTENCE);
        String result = String.join(", ", winners);
        System.out.println(result);
    }
}
