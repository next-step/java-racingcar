package racing.view;

import racing.model.RoundResult;

public class ResultView {

    private static final String WINNER_PRESENTATION = "가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void printNewLineMessage(String dialogue) {
        System.out.println(dialogue);
    }

    public static void printMessage(String dialogue) {
        System.out.print(dialogue);
    }

    public static void printResult(RoundResult roundResult) {
        printNewLineMessage(String.format("%s%S", roundResult.getWinners(), WINNER_PRESENTATION));
    }
}
