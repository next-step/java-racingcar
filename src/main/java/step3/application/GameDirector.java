package step3.application;

import step3.domain.board.GameBoard;
import step3.domain.car.Cars;
import step3.domain.car.Name;
import step3.domain.power.Engine;
import step3.domain.power.RandomEngine;

import java.util.List;

import static step3.utils.ValidationUtils.checkArgument;

public class GameDirector {

    private static final Engine engine = new RandomEngine();
    private static final int NAMES_MIN_SIZE = 0;

    private final Cars cars;
    private final Round round;

    public GameDirector(List<Name> names, Round round) {
        checkArguments(names, round);
        this.cars = Cars.of(names);
        this.round = round;
    }

    private void checkArguments(List<Name> names, Round round) {
        checkArgument(names != null && names.size() > NAMES_MIN_SIZE, "names is required");
        checkArgument(round != null, "round is required");
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
