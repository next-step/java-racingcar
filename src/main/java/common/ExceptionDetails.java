package common;

public enum ExceptionDetails {

    NOT_POSITIVE_NUMBER_EXCEPTION("양수만 입력해주세요."),
    INVALID_NUMBER_FORMAT_EXCEPTION("숫자 이외의 값은 입력할 수 없습니다."),
    UNEXPECTED_CHARACTER_EXCEPTION("숫자, 기본 구분자, 커스텀 구분자 외 문자는 입력할 수 없습니다.");

    private final String message;

    ExceptionDetails(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
