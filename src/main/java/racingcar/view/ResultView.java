package racingcar.view;

import racingcar.domain.Car;

public class ResultView {
    public static void displayRace(Car car) {
        System.out.println("-".repeat(car.getPosition()));
    }
}
