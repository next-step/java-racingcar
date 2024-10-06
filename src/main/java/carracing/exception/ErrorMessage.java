package carracing.exception;

public enum ErrorMessage {

    INVALID_NAME_LENGTH("이름은 5자를 초과할 수 없습니다.", "이름 길이 규칙을 만족하지 않는 경우"),
    INVALID_POSITION("자동차 위치는 0보다 작을 수 없습니다.", "자동차 위치가 유효하지 않는 경우"),
            ;

    private String message;
    private String description;

    ErrorMessage(String message, String description) {
        this.message = message;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
