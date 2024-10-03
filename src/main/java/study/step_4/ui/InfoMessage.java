package study.step_4.ui;

public enum InfoMessage {
    CAR_COUNT_QUESTION("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    ATTEMPT_COUNT_QUESTION("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT("실행 결과"),
    WHEEL_LOSS("바퀴가 빠졌습니다..."),
    FINAL_WINNER("가 최종 우승했습니다."),
    SKID_MARK("-");

    private final String message;

    InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}