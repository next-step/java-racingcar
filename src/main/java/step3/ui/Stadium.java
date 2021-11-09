package step3.ui;

import step3.application.GameDirector;
import step3.application.Round;
import step3.domain.board.GameBoard;
import step3.domain.car.Name;

import java.util.Scanner;

import static step3.ui.InputView.getCarNames;
import static step3.ui.InputView.getRoundCount;

public class Stadium {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String carNames = getCarNames();
        Integer roundSize = getRoundCount();

        GameDirector gameDirector = createGameDirector();
        GameBoard gameBoard = gameDirector.playGame();
        showGame(gameBoard, gameDirector);
    }

    private static GameDirector createGameDirector() {
        return new GameDirector(Name.listOf("나,우리,사람"), new Round(5));
    }

    private static void showGame(GameBoard gameBoard, GameDirector gameDirector) {
        GameResult gameResult = new GameResult(gameBoard, gameDirector.findWinnerNames());
        gameResult.showGame();
    }

}
