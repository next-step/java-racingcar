package racing.core.exception;

public enum ErrorMessage {

    NULL_OR_EMPTY_VALUE("자동차 이름은 반드시 문자나 숫자를 포함해야 합니다."),
    LENGTH_OVER("자동차 이름은 5자를 초과할 수 없습니다."),
    EMPTY_CARS("경주에 참가할 자동차가 존재하지 않습니다.");

    ErrorMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
