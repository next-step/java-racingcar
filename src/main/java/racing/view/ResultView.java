package racing.view;

import racing.GameResult;

public class ResultView {
    private static final String PRINT_RESULT_MESSAGE = "실행 결과";
    private static ResultView instance;

    private ResultView() {
    }

    public static ResultView getInstance() {
        if (instance == null) {
            instance = new ResultView();
        }
        return instance;
    }

    public void printResult(GameResult result) {
        System.out.println(PRINT_RESULT_MESSAGE);
        result.prints();
    }
}
