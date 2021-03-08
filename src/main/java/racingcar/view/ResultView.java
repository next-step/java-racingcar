package racingcar.view;

public class ResultView {

    private static final String HYPHEN = "-";

    public void printExecutionResult(int position) {

        StringBuilder hyphens = new StringBuilder();
        for (int i = 0;i<position;i++) {
            hyphens.append(HYPHEN);
        }
        System.out.println(hyphens);
    }

    public void printLiterallyExecutionResult() {
        System.out.println("실행 결과");
    }
}
