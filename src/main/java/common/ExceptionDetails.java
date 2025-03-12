package common;

public enum ExceptionDetails {

    NOT_POSITIVE_NUMBER_EXCEPTION("양수만 입력해주세요.");

    private final String message;

    ExceptionDetails(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
