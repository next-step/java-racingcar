package view;

import domain.Car;

import java.util.List;

public class ResultView {
    private static final String PLAY_RESULT = "실행 결과";
    private static final String HIPEN = "-";

    public static void printResult() {
        System.out.println("\n" + PLAY_RESULT);
    }

    public static void printPlayResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        int position = car.getPosition();
        for (int i = 0; i < position; i++) {
            System.out.print(HIPEN);
        }
    }
}
