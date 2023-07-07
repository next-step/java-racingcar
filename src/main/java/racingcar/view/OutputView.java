package racingcar.view;

import racingcar.domain.CarResponse;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    public static void printInitialStatus(Cars cars) {
        System.out.println("실행 결과");
        printExecutionResult(cars);
    }

    public static void printExecutionResult(Cars cars) {
        cars.getCars()
                .stream()
                .map(OutputView::formatResult)
                .forEach(System.out::println);
        System.out.println();
    }

    private static String formatResult(CarResponse c) {
        return c.getName() + " : " + "-".repeat(c.getPosition());
    }

    public static void printWinner(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종우승했습니다.");
    }
}
