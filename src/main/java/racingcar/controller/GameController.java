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

    private static Cars cars;
    private static int turn;

    public GameController(final String carsName, final int turn) {
        this.cars = new Cars(carsName);
        this.turn = turn;
    }

    private static void play(final MovableStrategy strategy) {
        for (int index = 0; index < turn; index++) {
            cars.moveAll(strategy);
            OutputView.printDistance(cars);
        }
    }

    public static void startGame(final MovableStrategy strategy) {
        OutputView.printTurnResult();
        play(strategy);

        OutputView.printWhoIsWinner(cars);
    }
}
