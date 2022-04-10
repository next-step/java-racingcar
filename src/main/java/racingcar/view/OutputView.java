package racingcar.view;

import racingcar.dto.RoundResult;
import racingcar.dto.RoundResults;

public class OutputView {
    public static void printPosition(int position) {
        System.out.print("|");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printGameResult(RoundResults roundResults) {
        System.out.println("실행 결과");

        for (RoundResult roundResult : roundResults.getRoundResults()) {
            printRoundResult(roundResult);
        }
    }

    public static void printRoundResult(RoundResult roundResult) {
        for (Integer carPosition : roundResult.getCarsPositions()) {
            printPosition(carPosition);
        }
        System.out.println();
    }
}
