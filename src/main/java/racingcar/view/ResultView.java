package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public static void display(List<Car> cars, int tryCount) {
        System.out.println("실행 결과");
        for (int count = 0; count < tryCount; count++) {
            displayRace(cars);
        }
    }

    private static void displayRace(List<Car> cars) {
        cars.forEach(car -> System.out.println("-".repeat(car.getPosition())));
        System.out.println();
    }
}
