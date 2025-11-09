package racingcar.view;

import racingcar.domain.RaceHistory;
import racingcar.domain.RoundResult;

public class ResultView {
    private static final String POSITION_SYMBOL = "-";
    private static final String RESULT_HEADER = "실행 결과";

    public static void printRaceHistory(RaceHistory raceHistory) {
        printBlankLine();
        print(RESULT_HEADER);

        for (RoundResult roundResult : raceHistory.getRounds()) {
            printRound(roundResult);
            printBlankLine();
        }
    }

    private static void printRound(RoundResult roundResult) {
        for (int position : roundResult.positions()) {
            print(POSITION_SYMBOL.repeat(Math.max(0, position)));
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void printBlankLine() {
        System.out.println();
    }
}
