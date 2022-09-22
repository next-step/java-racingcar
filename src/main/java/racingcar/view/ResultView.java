package racingcar.view;

import java.util.List;
import java.util.function.Consumer;

public class ResultView {
    private static final String RESULT_DELIMITER = "-";

    public static void printGameResult(List<List<Integer>> gameResult) {
        printResultComment();
        gameResult.forEach(printRoundResult());
    }

    private static Consumer<List<Integer>> printRoundResult() {
        return eachRound -> {
            eachRound.forEach(printCarResult());
            System.out.println();
        };
    }

    private static Consumer<Integer> printCarResult() {
        return carResult -> {
            printDelimitedResult(carResult);
            System.out.println();
        };
    }

    private static void printDelimitedResult(Integer carResult) {
        for (int i = 0; i < carResult; i++) {
            System.out.print(RESULT_DELIMITER);
        }
    }

    private static void printResultComment() {
        System.out.println("실행 결과");
    }
}
