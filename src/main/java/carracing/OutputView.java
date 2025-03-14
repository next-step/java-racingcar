package carracing;

import java.util.List;

public class OutputView {
    public static void printTotalResult(List<List<Integer>> result) {
        for (List<Integer> oneRound : result) {
            printOneRoundResult(oneRound);
            System.out.println();
        }
    }

    private static void printOneRoundResult(List<Integer> oneRound) {
        for (Integer distance : oneRound) {
            printCarDistance(distance);
            System.out.println();
        }
    }

    private static void printCarDistance(Integer distance) {
        for (int i = 0; i < distance; ++i) {
            System.out.print("-");
        }
    }
}
