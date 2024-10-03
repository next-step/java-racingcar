package study.step_3.ui;

public enum InfoMessage {
    CAR_COUNT_QUESTION("자동차 대수는 몇 대 인가요?"),
    ATTEMPT_COUNT_QUESTION("시도할 회수는 몇 회 인가요?"),
    EXECUTION_RESULT("실행 결과"),
    WHEEL_LOSS("바퀴가 빠졌습니다..."),
    SKID_MARK("-");

    private final String message;

    InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}