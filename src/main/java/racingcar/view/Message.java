package racingcar.view;

public enum Message {

    INPUT_CAR_NUMBER("자동차 대수는 몇 대인가요?"),

    INPUT_PLAY_COUNT("시도할 회수는 몇 회 인가요?"),

    WRONG_INPUT("잘못입력 하셨습니다."),

    FINAL_RESULT("실행 결과");

    private final String description;

    Message(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
