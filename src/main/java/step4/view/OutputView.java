package step4.view;

import step4.domain.GameResult;
import step4.domain.RoundResult;

import java.util.List;

public class OutputView {
    private static final String RESULT_STATEMENT = "실행 결과";
    private static final String MOVE_SYMBOL = "-";
    private static final String WINNER_STATEMENT = "가 우승했습니다.";
    private static final StringBuilder sb = new StringBuilder();

    public static void printResultStatement() {
        System.out.println();
        System.out.println(RESULT_STATEMENT);
    }

    public static void printRoundResult(RoundResult roundResult) {
        for (Integer carDistance : roundResult.roundList()) {
            String moveRecord = MOVE_SYMBOL.repeat(carDistance);
            sb.append(moveRecord).append("\n");
        }
        System.out.println(sb);
        sb.setLength(0);
    }

    public static void drawResultView(GameResult resultBoard) {
        for (RoundResult roundResult : resultBoard.resultBoard()) {
            printRoundResult(roundResult);
        }
    }

    public static void printWinner(List<String> winnerList) {
        String winnerNames = String.join(", ", winnerList);
        System.out.println(winnerNames + WINNER_STATEMENT);
    }
}
