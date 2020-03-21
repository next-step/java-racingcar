package racingGame.view;

public enum InputMessage {
    PARTICIPATE_COUNT("자동차 대수는 몇 대 인가요?"),
    GAME_COUNT("시도할 회수는 몇 회 인가요?");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
