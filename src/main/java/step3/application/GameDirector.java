package step3.application;

import step3.domain.board.GameBoard;
import step3.domain.car.Cars;
import step3.domain.power.Engine;
import step3.domain.power.RandomEngine;

import static step3.utils.ValidationUtils.checkArgument;

public class GameDirector {

    private static final Engine engine = new RandomEngine();

    private final Cars cars;
    private final Round round;

    public GameDirector(Integer carCount, Round round) {
        checkArguments(carCount, round);
        this.cars = Cars.of(carCount);
        this.round = round;
    }

    private void checkArguments(Integer carCount, Round round) {
        checkArgument(carCount != null, "carCount is not null");
        checkArgument(round != null, "round is not null");
    }

    public GameBoard playGame() {
        GameBoard gameBoard = new GameBoard();
        playGame(gameBoard);
        return gameBoard;
    }

    private void playGame(GameBoard gameBoard) {
        while (round.hasNext()) {
            cars.go(engine);
            round.decrease();
            gameBoard.recordRound(cars);
        }
    }
}
