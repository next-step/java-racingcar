package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.movable.MovableStrategy;
import racingcar.view.OutputView;

public class GameController {

    private final Cars cars;
    private final int turn;

    public GameController(final String carNames, final int turn) {
        this.cars = new Cars(carNames);
        this.turn = turn;
    }

    public void play(final MovableStrategy strategy) {
        OutputView.printTurnResult();
        moveCars(strategy);
        OutputView.printWhoIsWinner(cars);
    }

    private void moveCars(final MovableStrategy strategy) {
        for (int index = 0; index < turn; index++) {
            cars.moveAll(strategy);
            OutputView.printDistance(cars);
        }
    }

}
