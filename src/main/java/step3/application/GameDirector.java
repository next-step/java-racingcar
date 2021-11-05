package step3.application;

import step3.domain.board.GameBoard;
import step3.domain.car.Cars;
import step3.domain.power.RandomPower;

import static step3.utils.ValidationUtils.checkArgument;

public class GameDirector {

    private final GameBoard gameBoard;
    private final Engineer engineer;

    public GameDirector(GameBoard gameBoard, Engineer engineer) {
        checkArgument(gameBoard != null, "gameBoard is required");
        checkArgument(engineer != null, "engineer is required");

        this.gameBoard = gameBoard;
        this.engineer = engineer;
    }

    public void playGame(Integer carCount, Integer roundSize) {
        checkArgument(carCount != null, "carCount is required");
        checkArgument(roundSize != null, "roundSize is required");

        Cars cars = engineer.createCars(carCount, new RandomPower());
        for (int currentRound = 0; currentRound < roundSize; currentRound++) {
            cars.go();
            gameBoard.recordRound(cars);
        }
    }
}
