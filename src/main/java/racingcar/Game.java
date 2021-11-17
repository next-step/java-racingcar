package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.stream.IntStream;

public class Game {
    private MovingStrategy strategy;

    public Game() {
        this.strategy = new RandomMovingStrategy();
    }

    public Game(long randomSeed) {
        this.strategy = new RandomMovingStrategy(randomSeed);
    }

    public void racingCars() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Cars cars = inputView.initCars();
        IntStream.range(0, inputView.getRounds())
                .forEach(i -> resultView.printAllCarsMovement(cars.moveAll(this.strategy)));
    }
}
