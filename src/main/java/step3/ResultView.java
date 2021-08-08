package step3;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String PROGRESS_BAR = "-";

    public static void printResultStart() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(List<Cars> racingSheets) {
        for (Cars cars : racingSheets) {
            printRound(cars);
        }
    }

    private static void printRound(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCarName() + " : " + makeProgress(car.getMoveDistance()));
        }
        System.out.println();
    }

    private static String makeProgress(int moveDistance) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < moveDistance; i++) {
            stringBuilder.append(PROGRESS_BAR);
        }
        return String.valueOf(stringBuilder);
    }

    public static void printWinner(List<Car> winners) {
        String winner = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(","));
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
