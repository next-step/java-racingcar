package step3.view.input;

import java.util.function.Function;

public enum InputView {
    CAR_COUNT_VIEW("자동차 대수는 몇 대 인가요?"),
    CYCLE_COUNT_VIEW("시도할 회수는 몇 회 인가요?");

    final private String RESULT_TEXT = "실행 결과:";
    final private String question;

    InputView(String question) {
        this.question = question;
    }

    public void printQuestion() {
        System.out.println(this.question);
    }

    public void printResult() {
        System.out.println(RESULT_TEXT);
    }
}
