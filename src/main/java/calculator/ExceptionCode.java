package calculator;

public enum ExceptionCode {
    NEGATIVE_VALIDATION("0 이상의 값만 넣어주세요.");

    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
