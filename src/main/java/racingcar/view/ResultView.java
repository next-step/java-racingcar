package racingcar.view;

import racingcar.car.Car;
import racingcar.car.Cars;

public class ResultView {
    public static final int FIRST_ROUND = 1;

    public void showRoundResult(int roundNumber, Cars cars) {
        if (roundNumber == FIRST_ROUND) {
            System.out.println("\n실행 결과");
        }

        System.out.println("Round : " + roundNumber);
        for (Car car : cars.getCars()) {
            System.out.printf("[%3d] %s%n", car.getPosition(), "-".repeat(car.getPosition()));
        }
        System.out.println();

    }
}
