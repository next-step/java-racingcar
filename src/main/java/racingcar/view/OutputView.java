package racingcar.view;

public class OutputView {

    private static final String EXECUTION_RESULT = "실행 결과";

    public void printGameResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printSingleGameResult(String gameResult) {
        System.out.print(gameResult);
    }
}
