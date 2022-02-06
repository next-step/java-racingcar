package racingcar.controller;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.movable.MovableStrategy;
import racingcar.domain.movable.RandomMovableStrategy;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final Cars cars;
    private final int turn;

    private GameController(final String carsName, final int turn) {
        this.cars = Cars.fromString(carsName);
        this.turn = turn;
    }

    public static GameController of(final String carsName, final int turn) {
        return new GameController(carsName, turn);
    }

    private void play(final MovableStrategy strategy) {
        for (int index = 0; index < turn; index++) {
            cars.moveAll(strategy);
            OutputView.printDistance(cars);
        }
    }

    public void startGame(final MovableStrategy strategy) {
        OutputView.printTurnResult();
        play(strategy);

        OutputView.printWhoIsWinner(cars);
    }
}
