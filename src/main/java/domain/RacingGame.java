package domain;

import view.ConsoleResultView;

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
        this.play(new ConsoleResultView());
    }

    public void play(ResultView resultView) {
        while (moveCount-- > 0) {
            cars.move();
            resultView.print(cars);
        }
    }

    public Cars winner() {
        return cars.winners();
    }
}
