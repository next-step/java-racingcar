package step3.view.output;

public enum OutputText {
    CAR_COUNT_VIEW("자동차 대수는 몇 대 인가요?"),
    CYCLE_COUNT_VIEW("시도할 회수는 몇 회 인가요?"),
    RESULT_TEXT("실행 결과:");

    private final String question;

    OutputText(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }
}
