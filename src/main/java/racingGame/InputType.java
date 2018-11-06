package racingGame;

public enum InputType {
    CAR("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    MOVE("시도할 횟수는 몇 회 인가요?");

    private String message;

    InputType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
