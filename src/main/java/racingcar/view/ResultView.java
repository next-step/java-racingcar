package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.position()));
        }
        System.out.println();
    }
}
