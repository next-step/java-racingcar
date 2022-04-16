package step_3.view;

import step_3.model.FinalResult;
import step_3.util.BehaviorCombiner;

import java.util.stream.IntStream;

public class ResultView {

    private static final String BLANK = "";
    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";

    private ResultView() {
    }

    public static void printBlank() {
        System.out.println(BLANK);
    }

    public static void printMessage(String dialogue) {
        System.out.println(dialogue);
    }

    public static void printResult(FinalResult finalResult) {
        int totalRounds = finalResult.getRoundResults().size();

        String result = IntStream.range(1, totalRounds + 1)
                .mapToObj(BehaviorCombiner.combined(finalResult.getRoundResults()))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        printBlank();
        printMessage(EXECUTE_RESULT_MESSAGE);
        printMessage(result);
    }
}
