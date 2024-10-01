package racinggame;

import java.util.List;

public class ResultView {

    private ResultView() {
        throw new IllegalStateException("Utility class");
    }

    public static void printCarPositionByRound(List<List<Integer>> gameResults) {
        for (int round = 0; round < gameResults.size(); round++) {
            printRound(gameResults, round);
        }
    }

    private static void printRound(List<List<Integer>> gameResults, int round) {
        for (int carPosition = 0; carPosition < gameResults.get(round).size(); carPosition++) {
            System.out.println(getDashesByCount(gameResults.get(round).get(carPosition)));
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
