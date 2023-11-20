package step4.view;

import java.util.List;

public class OutputView {
    private static final String RESULT_STATEMENT = "실행 결과";
    private static final String MOVE_SYMBOL = "-";
    private static final String WINNER_STATEMENT = "가 우승했습니다.";

    public static void printResultStatement() {
        System.out.println();
        System.out.println(RESULT_STATEMENT);
    }

    public static void printRoundResult(List<Integer> roundResult) {
        for (Integer carDistance : roundResult) {
            System.out.println(MOVE_SYMBOL.repeat(carDistance));
        }
        System.out.println();
    }

    public static void drawResultView(List<List<Integer>> resultBoard) {
        for (List<Integer> roundResult : resultBoard) {
            printRoundResult(roundResult);
        }
    }

    public static void printWinner(List<String> winnerList) {
        String winnerNames = String.join(", ", winnerList);
        System.out.println(winnerNames + WINNER_STATEMENT);
    }
}
