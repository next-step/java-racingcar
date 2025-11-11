package racingcar.view;

import racingcar.domain.CarSnapshot;
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
        for (CarSnapshot snapshot : roundResult.snapshots()) {
            print(POSITION_SYMBOL.repeat(Math.max(0, snapshot.distance())));
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void printBlankLine() {
        System.out.println();
    }
}
