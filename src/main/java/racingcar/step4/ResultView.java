package racingcar.step4;

import java.util.List;

public class ResultView {
    private static String RESULT_MESSAGE = "실행 결과";
    private static final String DISTANCE_SYMBOL = "-";

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
}
