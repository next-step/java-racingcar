package view;

import java.util.List;

public class ResultView {

    public static void printResult(List<List<Integer>> carPositionsAtTurns) {
        System.out.println("실행 결과");
        for (List<Integer> carPositions : carPositionsAtTurns) {
            printTurnResult(carPositions);
        }
    }

    private static void printTurnResult(List<Integer> carPositions) {
        for (int carPosition : carPositions) {
            printCarPosition(carPosition);
        }
        System.out.println();
    }

    private static void printCarPosition(int carPosition) {
        System.out.println("-".repeat(carPosition));
    }

}
