package racingcar.common;

public enum ExceptionMessage {
    WRONG_CAR_NAMES("잘못된 입력입니다."),
    WRONG_CAR_NAME("잘못된 자동차 이름입니다. 1~5자의 이름을 입력하세요.")
    ;

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String buildMessage(String data) {
        return "[" + data + "]" + this.message;
    }
}
