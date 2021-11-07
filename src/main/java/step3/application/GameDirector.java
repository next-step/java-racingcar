package step3.application;

import step3.domain.board.GameBoard;
import step3.domain.car.Cars;
import step3.domain.power.RandomEngine;

import static step3.utils.ValidationUtils.checkArgument;

public class GameDirector {

    private final GameBoard gameBoard;

    public GameDirector(GameBoard gameBoard) {
        checkArgument(gameBoard != null, "gameBoard is required");

        this.gameBoard = gameBoard;
    }

    public void playGame(Integer carCount, Integer roundSize) {
        checkArgument(carCount != null, "carCount is required");
        checkArgument(roundSize != null, "roundSize is required");

        Cars cars = Engineer.createCars(carCount, new RandomEngine());
        for (int currentRound = 0; currentRound < roundSize; currentRound++) {
            cars.go();
            gameBoard.recordRound(cars);
        }
    }
}
