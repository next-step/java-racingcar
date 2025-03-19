package util;

import racingcar.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void showResultMessage() {
        System.out.println("실행 결과");
    }

    private static void showCarResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + ":" + "-".repeat(car.getDistance()));
        }
    }

    private static void showEndOfTry() {
        System.out.println();
    }

    public static void showCarGameResult(List<Car> cars) {
        showCarResult(cars);
        showEndOfTry();
    }

    public static void showCarGameWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(","));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
