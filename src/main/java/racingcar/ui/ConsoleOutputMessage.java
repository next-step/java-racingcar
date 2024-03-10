package racingcar.ui;

public enum ConsoleOutputMessage {

    HOW_MANY_CARS("자동차 대수는 몇 대 인가요?"),
    HOW_MANY_TRYS("시도할 횟수는 몇 회 인가요?"),
    EXECUTE_RESULT("실행 결과");

    private final String message;

    ConsoleOutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
