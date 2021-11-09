package step3.ui;

import step3.application.GameDirector;
import step3.application.Round;
import step3.domain.board.GameBoard;
import step3.domain.car.Name;

import java.util.Scanner;

public class Stadium {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        String carNames = SCANNER.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        Integer roundSize = Integer.parseInt(SCANNER.nextLine());

        GameBoard gameBoard = playGame(carNames, roundSize);
        showGame(gameBoard);
    }

    private static GameBoard playGame(String carNames, Integer roundSize) {
        GameDirector gameDirector = new GameDirector(Name.listOf(carNames), new Round(roundSize));
        return gameDirector.playGame();
    }

    private static void showGame(GameBoard gameBoard) {
        GameResult gameResult = new GameResult(gameBoard);
        gameResult.showGame();
    }

}
