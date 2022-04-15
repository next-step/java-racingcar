package step3.view;

import step3.model.EachTryResult;
import step3.model.GameResult;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class ResultView {

    private static final String START = "[START]";
    private static final String DISPLAY_CHARACTER = ">";
    private static final String LINE_BREAK_PER_CAR = "\n";
    private static final String LINE_BREAK_PER_EACH_TRY = "----------";
    private static final String END = "[END]";


    public void printResult(GameResult gameResult) {
        show(START);
        showGameResult(gameResult);
        show(END);
    }

    private void showGameResult(GameResult gameResult) {
        List<EachTryResult> eachTryResults = gameResult.getEachTryResults();
        eachTryResults.stream()
                .map(this::parseToString)
                .forEach(this::showEachResult);
    }

    private String parseToString(EachTryResult eachTryResult) {
        List<Integer> successCounts = eachTryResult.getSuccessCounts();
        return successCounts.stream()
                .map(DISPLAY_CHARACTER::repeat)
                .collect(Collectors.joining(LINE_BREAK_PER_CAR));
    }

    private void showEachResult(String eachResult) {
        show(eachResult);
        lineBreak();
    }


    private void lineBreak() {
        show(LINE_BREAK_PER_EACH_TRY);
    }

    private void show(String output) {
        out.println(output);
    }
}
