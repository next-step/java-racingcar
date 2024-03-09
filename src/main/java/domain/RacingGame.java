package domain;

import view.ResultView;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private int moveCount;

    public RacingGame(List<Car> cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public void play() {
        while (moveCount-- > 0) {
            move();
            ResultView.print(cars);
        }
    }

    private void move() {
        for (Car car : cars) {
            car.move();
        }
    }
}
