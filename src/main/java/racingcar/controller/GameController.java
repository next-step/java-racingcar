package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Turn;
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
        List<ResultDto> result = cars.moveAll(strategy, new Turn(turn));
        OutputView.printDistance(result, cars.get().size());
    }

}
