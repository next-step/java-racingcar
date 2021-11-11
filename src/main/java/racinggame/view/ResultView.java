package racinggame.view;

import racinggame.MoveResult;

import java.util.List;

public class ResultView {

    private static final String EXECUTE_RESULT_MESSAGE = "실행결과";
    private static final String ROUND_DIVISION = "";
    private static final String OUTPUT_SYMBOL = "-";

    private final List<MoveResult> moveResults;

    public ResultView(List<MoveResult> moveResults) {
        this.moveResults = moveResults;
    }

    public void showResult() {
        System.out.println(EXECUTE_RESULT_MESSAGE);

        moveResults.forEach(moveResult -> {
            moveResult.getResults()
                    .forEach(result -> System.out.println(printResult(result.currentPosition())));
            System.out.println(ROUND_DIVISION);
        });
    }

    private String printResult(int result) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result; i++) {
            builder.append(OUTPUT_SYMBOL);
        }

        return builder.toString();
    }
}
