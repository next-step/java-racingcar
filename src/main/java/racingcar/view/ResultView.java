package racingcar.view;

import racingcar.dto.RoundResult;

public class ResultView {
    private ResultView() {
    }

    public static void showResultTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void showRound(RoundResult roundResult) {
        System.out.println(roundResult.formatProgress());
        System.out.println();
    }

    public static void showWinners(RoundResult roundResult) {
        System.out.println(roundResult.formatWinners());
    }
}
