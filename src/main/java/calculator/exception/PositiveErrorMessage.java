package calculator.exception;

public enum PositiveErrorMessage {
    NOT_ALLOWED_ZERO("0은 허용되지 않습니다."),
    NOT_ALLOWED_NEGATIVE("음수는 허용되지 않습니다.");

    private final String message;

    PositiveErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
