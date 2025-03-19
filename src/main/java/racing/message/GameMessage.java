package racing.message;

public enum GameMessage {
    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    ROUND_COUNT_INPUT_MESSAGE("시도할 회수는 몇 회 인가요?"),
    HEAD_OF_OUTPUT_MESSAGE("실행 결과"),
    WINNERS_OUTPUT_MESSAGE("%s 가 최종 우승했습니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getGameMessage() {
        return message;
    }
}
