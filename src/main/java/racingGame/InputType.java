package racingGame;

public enum InputType {
    CAR("자동차 대수는 몇 대인가요?"),
    MOVE("시도할 횟수는 몇 회 인가요?");

    private String message;

    InputType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
