package racing.view;

import racing.domain.RaceResult;
import racing.domain.RoundResult;

public class OutputView {

    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_MARK = "-";

    public static void printRaceResult(RaceResult raceResult) {
        System.out.println(RACE_RESULT_MESSAGE);

        for (RoundResult roundResult : raceResult.getRaceResult()) {
            printRoundResult(roundResult);
        }
    }

    private static void printRoundResult(RoundResult roundResult) {
        for (int position : roundResult.getRoundResult()) {
            System.out.println(POSITION_MARK.repeat(position));
        }
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }
}
