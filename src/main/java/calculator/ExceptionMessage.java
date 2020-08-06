package calculator;

public enum  ExceptionMessage {
    EMPTY_OR_NULL_ARGUMENT("null 또는 빈 공백의 문자열입니다."),
    INCORRECT_NUMBER_OF_ARGUMENTS("연산자와 피연산자 개수가 올바르지 않습니다."),
    NOT_ARITHMETIC_OPERATOR("사칙연산 기호가 아닙니다."),
    DIVIDED_BY_ZERO("0으로 나눌 수 없습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
