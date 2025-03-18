package racing.message;

public enum GameMessage {
    CAR_INFO_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    ATTEMPT_COUNT_INPUT_MESSAGE("시도할 회수는 몇 회 인가요?"),
    OUTPUT_HEAD_MESSAGE("실행 결과");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getGameMessage() {
        return message;
    }
}
