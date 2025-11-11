package racingcar.view;

import java.io.PrintStream;
import racingcar.domain.CarSnapshot;
import racingcar.domain.RaceHistory;
import racingcar.domain.RoundResult;

public class ResultView {
    private static final String POSITION_SYMBOL = "-";
    private static final String RESULT_HEADER = "실행 결과";
    private static final String WINNER_SUFFIX = "가 최종 우승했습니다.";
    private static final String NAME_DISTANCE_FORMAT = "%s : %s";
    private static final PrintStream OUT = System.out;

    private ResultView() {
        throw new AssertionError("인스턴스화를 지원하지 않습니다.");
    }

    public static void printRaceHistory(RaceHistory raceHistory) {
        printHeader();
        printAllRounds(raceHistory);
        printWinner(raceHistory);
    }

    private static void printHeader() {
        println();
        println(RESULT_HEADER);
    }

    private static void printAllRounds(RaceHistory raceHistory) {
        for (RoundResult round : raceHistory.getRounds()) {
            printRound(round);
            println();
        }
    }

    private static void printRound(RoundResult roundResult) {
        for (CarSnapshot snapshot : roundResult.snapshots()) {
            String carStatus = String.format(
                    NAME_DISTANCE_FORMAT, snapshot.name(), POSITION_SYMBOL.repeat(Math.max(0, snapshot.distance())));
            println(carStatus);
        }
    }

    private static void printWinner(RaceHistory raceHistory) {
        String winners = String.join(", ", raceHistory.winners());
        println(winners + WINNER_SUFFIX);
    }

    private static void println(String message) {
        OUT.println(message);
    }

    private static void println() {
        OUT.println();
    }
}
