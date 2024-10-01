package step4.message;

public enum Message {

    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    INPUT_CAR_NUM("자동차 대수는 몇 대 인가요?"),
    INPUT_ATTEMPT_NUM("시도할 회수는 몇 회 인가요?"),

    WINNER("{winner}가 최종 우승했습니다."),

    RESULT_MESSAGE("실행결과");

    Message(String message) {
        this.message = message;
    }

    private final String message;

    public String message() {
        return message;
    }
}
