package racingcar;

import java.util.List;

public class Output {

    public static void printInitialStatus(List<Car> cars) {
        System.out.println("실행 결과");
        printExecutionResult(cars);
    }

    public static void printExecutionResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종우승했습니다.");
    }
}
