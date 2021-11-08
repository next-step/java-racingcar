package step3.ui;

import step3.application.GameDirector;
import step3.application.Round;
import step3.domain.board.GameBoard;

import java.util.Scanner;

public class Stadium {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Integer carCount = Integer.parseInt(SCANNER.nextLine());

        System.out.println("시도할 회수는 몇 회 인가요?");
        Integer roundSize = Integer.parseInt(SCANNER.nextLine());

        GameBoard gameBoard = playGame(carCount, roundSize);
        showGame(gameBoard);
    }

    private static GameBoard playGame(Integer carCount, Integer roundSize) {
        GameDirector gameDirector = new GameDirector(carCount, new Round(roundSize));
        return gameDirector.playGame();
    }

    private static void showGame(GameBoard gameBoard) {
        GameResult gameResult = new GameResult(gameBoard);
        gameResult.showGame();
    }

}
