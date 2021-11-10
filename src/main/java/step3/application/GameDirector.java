package step3.application;

import step3.domain.board.CarSnapshot;
import step3.domain.board.GameBoard;
import step3.domain.car.Cars;
import step3.domain.car.Name;
import step3.domain.car.Names;
import step3.domain.power.Engine;
import step3.domain.power.RandomEngine;

import java.util.List;

import static step3.utils.ValidationUtils.checkArgument;

public class GameDirector {

    private static final Engine engine = new RandomEngine();

    private final Cars cars;
    private final Round round;

    public GameDirector(Names names, Round round) {
        checkArguments(names, round);
        this.cars = names.convertToCar();
        this.round = round;
    }

    private void checkArguments(Names names, Round round) {
        checkArgument(names != null, "names is required");
        checkArgument(round != null, "round is required");
    }

    public GameBoard playGame() {
        GameBoard gameBoard = new GameBoard();
        playGame(gameBoard);
        return gameBoard;
    }

    private void playGame(GameBoard gameBoard) {
        while (round.hasNext()) {
            round.decrease();
            List<CarSnapshot> carSnapshots = cars.go(engine);
            gameBoard.recordRound(carSnapshots);
        }
    }

    public List<Name> findWinnerNames() {
        return cars.findWinnerNames();
    }
}
