package racingcar.view;

public class ResultView {
    public void printNumberOfCarQuestion() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void printCarCountQuestion() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void printLiterallyExecutionResult() {
        System.out.println("실행 결과");
    }

    public void printExecutionResult(int position) {
        String HYPHEN = "-";
        StringBuilder hyphens = new StringBuilder();
        for(int i = 0;i<position;i++) {
            hyphens.append(HYPHEN);
        }
        System.out.println(hyphens);
    }
}
