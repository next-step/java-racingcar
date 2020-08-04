package step3.view.input;

import java.util.function.Function;

public enum InputView {
    CAR_COUNT_VIEW("자동차 대수는 몇 대 인가요?", (carCount) -> carCount),
    CYCLE_COUNT_VIEW("시도할 회수는 몇 회 인가요?", (cycleCount -> cycleCount));

    final private String RESULT_TEXT = "실행 결과:";
    final private String question;
    final private Function<Integer, Integer> count;

    InputView(String question, Function<Integer, Integer> count) {
        this.question = question;
        this.count = count;
    }

    public void printQuestion() {
        System.out.println(this.question);
    }

    public void printCount(Integer count) {
        System.out.println(this.count.apply(count));
    }

    public void printResult() {
        System.out.println(RESULT_TEXT);
    }
}
