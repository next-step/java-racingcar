package racing.view;

import racing.GameResult;

public class ResultView {

    public static final String PRINT_RESULT_MESSAGE = "실행 결과";

    public void printResult(GameResult result) {
        System.out.println(PRINT_RESULT_MESSAGE);
        result.prints();
    }
}
