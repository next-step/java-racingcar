package racingcar.view;

import racingcar.car.Car;

import java.util.List;

public class ResultView {


    public void showRoundResult(int roundNumber, List<Car> cars) {
        if (roundNumber == 1) {
            System.out.println("\n실행 결과");
        }

        System.out.println("Round : " + roundNumber);
        for (Car car : cars) {
            System.out.printf("[%3d] %s%n", car.getPosition(), "-".repeat(car.getPosition()));
        }
        System.out.println();

    }
}
