package racing.message;

public enum GameMessage {
    CAR_COUNT_MESSAGE("자동차 대수는 몇 대 인가요?"),
    ATTEMPT_COUNT_MESSAGE("시도할 회수는 몇 회 인가요?"),
    OUTPUT_HEAD_MESSAGE("실행 결과");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getGameMessage() {
        return message;
    }
}
