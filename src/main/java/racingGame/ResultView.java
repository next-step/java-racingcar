package racingGame;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printRound(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    private static void printCar(Car car) {
        System.out.println(car);
    }

    public static void printWinners(List<Car> cars) {
        String winners = String.join(", ", cars.stream()
            .map(Car::getName).collect(Collectors.toList()));
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
