package racinggame.view;

import java.util.List;
import java.util.Map;
import racinggame.core.scoreboard.ScoreBoard;
import racinggame.core.scoreboard.Score;

public class ScoreScreen {

    public static void printWinner(ScoreBoard scoreBoard) {
        List<String> winners = scoreBoard.getWinner(scoreBoard.getCountOfRound());
        System.out.printf(
                "%s가 최종 우승했습니다.%n",
                String.join(" ,", winners.toArray(new String[0]))
        );
    }

    public static void printScoreBoard(ScoreBoard scoreBoard) {
        System.out.println("실행 결과");

        for (int i = 1; i <= scoreBoard.getCountOfRound(); i++) {
            printRoundResult(scoreBoard.getScore(i));
        }
    }

    private static void printRoundResult(Score score) {
        Map<String, Integer> scoreInfo = score.getAllScore();
        for (Map.Entry<String, Integer> entry : scoreInfo.entrySet()) {
            System.out.printf("%s : %s%n",
                    entry.getKey(),
                    "-".repeat(entry.getValue())
            );
        }
        System.out.println();
    }

}
