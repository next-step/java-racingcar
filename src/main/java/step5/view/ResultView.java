package step5.view;

import step5.domain.racing.Racing;
import step5.domain.racing.cars.ScoreBoard;

import java.util.List;

/**
 * Created By mand2 on 2020-11-04.
 * 출력판
 */
public class ResultView {

    private final static String DASH = "-";
    private final static String DELIMITER = " : ";
    private final static String COMMAND_LINE_RESULT_MESSAGE = "실행 결과";
    private final static String WINNER_IS_WHOM = "가 최종 우승했습니다.";

    public static void printResult(Racing racing) {
        printScoreBoard(racing.getScoreBoard(), racing.getRounds());
        printWinner(racing.getWinner());
    }

    private static void printScoreBoard(List<ScoreBoard> score, int rounds) {
        printResultMessage();
        for (int i = 0; i < rounds; i++) {
            printRounds(score, i);
            System.out.println();
        }
    }

    public static void printWinner(String winners) {
        System.out.print(winners);
        System.out.println(WINNER_IS_WHOM);
    }

    private static void printResultMessage() {
        System.out.println(COMMAND_LINE_RESULT_MESSAGE);
    }

    private static void printRounds(List<ScoreBoard> scoreBoards, int round) {
        for (ScoreBoard scoreBoard : scoreBoards) {
            System.out.print(scoreBoard.getName() + DELIMITER);
            printDash(scoreBoard.getScoreHistory().get(round));
        }
    }

    private static void printDash(int score) {
        for (int i = 0; i < score; i++) {
            System.out.print(DASH);
        }
        System.out.println();
    }

}
