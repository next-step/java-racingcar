package calculator.exception;

public enum ErrorMessage {
    NOT_ALLOWED_NEGATIVE("음수는 허용되지 않습니다."),
    NON_NUMERICAL("숫자 이외의 값은 허용되지 않습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
