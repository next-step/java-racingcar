package step3.ui;

import step3.application.GameDirector;
import step3.application.Round;
import step3.domain.board.GameBoard;
import step3.domain.car.Names;

import static step3.ui.InputView.getCarNames;
import static step3.ui.InputView.getRoundCount;

public class Stadium {

    public static void main(String[] args) {
        String carNames = getCarNames();
        Integer roundSize = getRoundCount();

        GameDirector gameDirector = createGameDirector(carNames, roundSize);
        GameBoard gameBoard = gameDirector.playGame();
        showGame(gameBoard, gameDirector);
    }

    private static GameDirector createGameDirector(String carNames, Integer roundSize) {
        return new GameDirector(Names.from(carNames), new Round(roundSize));
    }

    private static void showGame(GameBoard gameBoard, GameDirector gameDirector) {
        GameResult gameResult = new GameResult(gameBoard, gameDirector.findWinnerNames());
        gameResult.showGame();
    }

}
