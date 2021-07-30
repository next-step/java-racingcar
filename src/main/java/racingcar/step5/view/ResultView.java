package racingcar.step5.view;


import racingcar.step5.domain.Car;

import java.util.List;

public class ResultView {
    private static String RESULT_MESSAGE = "실행 결과";
    private static final String DISTANCE_SYMBOL = "-";
    private static final String DELIMITER = ",";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void showGameResult(List<Car> racingCars) {
        for (Car car : racingCars) {
            printResultContents(car);
        }
        System.out.println();
    }

    private static void printResultContents(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getDistance(); i++) {
            sb.append(DISTANCE_SYMBOL);
        }
        System.out.println(sb);
    }

    public static void printWinnerNames(List<String> winners) {
        System.out.println(String.join(DELIMITER, winners) + "가 최종 우승했습니다.");

    }
}
