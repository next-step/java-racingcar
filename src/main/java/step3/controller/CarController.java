package step3.controller;

import step3.application.GameDirector;
import step3.application.Round;
import step3.controller.view.GameResult;
import step3.domain.board.GameBoard;
import step3.domain.car.Name;

import static step3.controller.view.InputView.getCarNames;
import static step3.controller.view.InputView.getRoundCount;

public class CarController {

    public static void main(String[] args) {
        String carNames = getCarNames();
        Integer roundSize = getRoundCount();

        GameDirector gameDirector = createGameDirector(carNames, roundSize);
        GameBoard gameBoard = gameDirector.playGame();
        showGame(gameBoard, gameDirector);
    }

    private static GameDirector createGameDirector(String carNames, Integer roundSize) {
        return new GameDirector(Name.listOf(carNames), new Round(roundSize));
    }

    private static void showGame(GameBoard gameBoard, GameDirector gameDirector) {
        GameResult gameResult = new GameResult(gameBoard, gameDirector.findWinners());
        gameResult.showGame();
    }

}
