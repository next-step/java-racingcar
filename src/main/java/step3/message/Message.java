package step3.message;

public enum Message {

    INPUT_CAR_NUM("자동차 대수는 몇 대 인가요?"),
    INPUT_ATTEMPT_NUM("시도할 회수는 몇 회 인가요?"),

    RESULT_MESSAGE("실행결과");

    Message(String message) {
        this.message = message;
    }

    private final String message;

    public String message() {
        return message;
    }
}
