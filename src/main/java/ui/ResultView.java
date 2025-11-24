package ui;

import model.Car;

import java.util.List;

public class ResultView {
    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    public static void printResultStart() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printRacingStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.printf("%s(이)가 최종 우승했습니다.", String.join(", ", winnerNames));
    }
}
