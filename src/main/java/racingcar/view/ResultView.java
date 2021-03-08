package racingcar.view;

public class ResultView {

    public void printExecutionResult(int position) {
        String HYPHEN = "-";
        StringBuilder hyphens = new StringBuilder();
        for (int i = 0;i<position;i++) {
            hyphens.append(HYPHEN);
        }
        System.out.println(hyphens);
    }

    public void drawLiterallyExecutionResult() {
        System.out.println("실행 결과");
    }
}
