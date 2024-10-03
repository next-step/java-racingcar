package study.step_2.constant.error;

public enum ErrorMessage {
    INVALID_NEGATIVE_NUMBER("음수 값은 허용되지 않습니다."),
    INVALID_NUMBER_TYPE("숫자 이외의 값은 허용되지 않습니다."),
    INVALID_DELIMITER_TYPE("구분자는 숫자를 사용할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}