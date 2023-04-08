package study.carrace.step3.presentation;

public enum PromptMessage {
    CAR_QUANTITY_QUESTION_MESSAGE("자동차 대수는 몇 대 인가요? "),
    ITERATION_COUNT_QUESTION_MESSAGE("시도할 회수는 몇 회 인가요? ");

    private final String message;

    PromptMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
