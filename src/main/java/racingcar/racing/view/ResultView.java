package racingcar.racing.view;

import racingcar.racing.model.Car;

import java.util.List;

public class ResultView {
    private static final String RESULT_POSTFIX = "가 최종 우승했습니다.";

    public static void printGameStatus(List<Car> cars, int stage) {
        System.out.println("stage: " + stage);
        cars.forEach(car -> System.out.printf("%-5s : %s%n", car.getCarName(), "-".repeat(car.getPosition())));
        System.out.println();
    }

    public static void printResult(List<String> winners) {
        System.out.printf("%s%s\n", String.join(", ", winners), RESULT_POSTFIX);
    }
}
