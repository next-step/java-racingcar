package racingCar.views;

import racingCar.domains.Car;

import java.util.List;
import java.util.StringJoiner;

public class ResultView {
    public static void showRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + ": " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void showWinners(List<Car> winners) {
        StringJoiner joiner = new StringJoiner(", ");
        for (Car car : winners) {
            joiner.add(car.getName());
        }
        System.out.println(joiner.toString() + "가 최종 우승했습니다.");
    }
}
