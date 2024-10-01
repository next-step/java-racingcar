package racinggame.ui;

import racinggame.domain.GameRounds;

public class ResultView {

    private ResultView() {
        throw new IllegalStateException("Utility class");
    }

    public static void printCarPositionByRound(GameRounds gameRounds) {
        for (int round = 0; round < gameRounds.getRoundCount(); round++) {
            printRound(gameRounds, round);
        }
    }

    private static void printRound(GameRounds gameResults, int round) {
        for (int car = 0; car < gameResults.getCarCount(round); car++) {
            System.out.println(getDashesByCount(gameResults.getCarPosition(round, car)));
        }
        printNewLine();
    }

    private static String getDashesByCount(int count) {
        return "-".repeat(count);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
