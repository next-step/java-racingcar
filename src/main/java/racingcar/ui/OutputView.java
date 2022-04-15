package racingcar.ui;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    private static final String RESULT_GUIDE = "실행 결과";

    public static void guide() {
        System.out.println(RESULT_GUIDE);
    }

    public static void racingResult(int trialNumber, int carNumber, List<List<Integer>> moveDistanceTrace) {
        for (int trialStep = 0; trialStep < trialNumber; trialStep++) {
            printPerTrial(trialStep, carNumber, moveDistanceTrace);
        }
    }

    private static void printPerTrial(int trialStep, int carNumber, List<List<Integer>> moveDistanceTrace) {
        for (int carIndex = 0; carIndex < carNumber; carIndex++) {
            System.out.println("-".repeat(moveDistanceTrace.get(carIndex).get(trialStep)));
        }
        endLine();
    }

    static void endLine() {
        System.out.println();
    }
}
