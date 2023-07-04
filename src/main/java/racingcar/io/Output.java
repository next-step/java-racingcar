package racingcar.io;

import racingcar.car.Cars;

import java.util.List;

public class Output {

    public static void printInitialStatus(Cars cars) {
        System.out.println("실행 결과");
        printExecutionResult(cars);
    }

    public static void printExecutionResult(Cars cars) {
        System.out.println(cars.getTotalStatus());
        System.out.println();
    }

    public static void printWinner(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종우승했습니다.");
    }
}
