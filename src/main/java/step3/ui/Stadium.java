package step3.ui;

import step3.application.GameDirector;
import step3.application.Round;
import step3.domain.board.GameBoard;
import step3.domain.car.Name;

import java.util.Scanner;

public class Stadium {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println("자동차 대수는 몇 대 인가요?");
//        String carNames = SCANNER.nextLine();
//
//        System.out.println("시도할 회수는 몇 회 인가요?");
//        Integer roundSize = Integer.parseInt(SCANNER.nextLine());

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
