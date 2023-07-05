package racingcar.io;

import racingcar.car.CarResponse;
import racingcar.car.Cars;

import java.util.List;

public class Output {

    public static void printInitialStatus(Cars cars) {
        System.out.println("실행 결과");
        printExecutionResult(cars);
    }

    public static void printExecutionResult(Cars cars) {
        cars.getCars()
                .stream()
                .map(Output::formatResult)
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
