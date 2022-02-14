package racingcar.controller;

import racingcar.domain.CarMoveHistory;
import racingcar.domain.Cars;
import racingcar.domain.movable.MovableStrategy;
import racingcar.view.OutputView;

public class GameController {

    private static final String VALIDATE_TURN_EXCEPTION_MESSAGE = "[ERROR] turn은 1 이상 정수이어야 합니다.";

    private final Cars cars;
    private final int turn;

    private GameController(final String carsName, final int turn) {
        this.cars = Cars.fromString(carsName);
        this.turn = turn;

        validateTurn(turn);
    }

    public static GameController of(final String carsName, final int turn) {
        return new GameController(carsName, turn);
    }

    private void play(final MovableStrategy strategy) {
        CarMoveHistory carMoveHistory = CarMoveHistory.create();

        for (int index = 0; index < turn; index++) {
            carMoveHistory.add(cars.moveAll(strategy));
        }

        OutputView.printMoveHistory(carMoveHistory);
    }

    public void startGame(final MovableStrategy strategy) {
        OutputView.printTurnResult();
        play(strategy);

        OutputView.printWhoIsWinner(cars);
    }

    private void validateTurn(int turn) {
        if (turn <= 0) {
            throw new IllegalArgumentException(VALIDATE_TURN_EXCEPTION_MESSAGE);
        }
    }
}
