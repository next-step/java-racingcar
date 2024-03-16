package domain;

import view.ResultView;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private int moveCount;

    public RacingGame(List<Car> cars, int moveCount) {
        this(new Cars(cars), moveCount);
    }

    public RacingGame(Cars cars, int moveCount) {
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
        cars.move();
    }

    public Cars winner() {
        return cars.winners();
    }
}
