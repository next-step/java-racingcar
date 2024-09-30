package stringadder.exception;

public enum ErrorMessage {

    INVALID_NEGATIVE_INPUT_NUMBER("음수는 더할 수 없습니다.", "문자열 덧셈기 인자로 음수가 들어올 경우"),
    DELIMITER_NOT_FOUND("구분자를 찾을 수 없습니다.", "입력값에서 구분자를 찾을 수 없는 경우")
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
