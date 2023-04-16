package racingcar;

import java.util.List;

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
        System.out.println(car.getName()+" : "+"-".repeat(car.getPosition()));
    }

    public static void printWinner(List<Car> cars) {
        System.out.println(String.join(", ", cars.stream()
                .map(Car::getName)
                .toArray(String[]::new)) + "가 최종 우승했습니다.");
    }
}
