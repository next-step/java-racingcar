package study.carrace.step3.presentation;

public enum PromptMessage {
    CAR_QUANTITY_QUESTION_MESSAGE("자동차 대수는 몇 대 인가요? "),
    ITERATION_COUNT_QUESTION_MESSAGE("시도할 회수는 몇 회 인가요? "),
    RACE_CAR_NAMES_QUESTION_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

    private final String message;

    PromptMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
