package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void printExecutionResult() {
        System.out.println("\n실행 결과");
    }

    public static void printCarPosition(List<Car> cars) {
        for (Car car : cars) {
            printPosition(car);
        }
        System.out.println();
    }

    private static void printPosition(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printWinner(List<Car> cars) {
        System.out.println(cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ")) + "가 최종 우승했습니다.");
    }
}
