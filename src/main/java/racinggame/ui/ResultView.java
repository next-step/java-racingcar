package racinggame.ui;

import racinggame.domain.GameRounds;

public class ResultView {
    public static final String SUFFIX_WINNER = "가 최종 우승했습니다.";

    private ResultView() {
        throw new IllegalStateException("Utility class");
    }

    public static void printCarPositionByRound(GameRounds gameRounds) {
        for (int round = 0; round < gameRounds.getRoundCount(); round++) {
            printRound(gameRounds, round);
        }
        printWinner(gameRounds);
    }

    private static void printRound(GameRounds gameResults, int round) {
        for (int car = 0; car < gameResults.getCarCount(round); car++) {
            String name = gameResults.getCarName(round, car);
            int position = gameResults.getCarPosition(round, car);
            System.out.println(name + " : " + getDashesByCount(position));
        }
        printNewLine();
    }

    private static void printWinner(GameRounds gameResults) {
        String winners = String.join(",", gameResults.getWinner());
        System.out.println(winners + SUFFIX_WINNER);
    }

    private static String getDashesByCount(int count) {
        return "-".repeat(count);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
