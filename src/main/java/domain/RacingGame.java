package domain;

import view.ResultView;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            move(car);
        }
    }

    private static void move(Car car) {
        while (car.moveable()) {
            car.move();
        }
        ResultView.print(car);
    }
}
