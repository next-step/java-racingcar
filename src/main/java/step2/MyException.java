package step2;

public enum MyException {

    EMPTY_INPUT("입력값이 비었습니다"),

    INVALID_NUMBER("유효하지 않은 숫자입니다."),
    INVALID_OPERATOR("유효하지 않은 사칙연산입니다."),

    NOT_DROP_TO_INTEGER("정수로 나누어 떨어지지 않습니다."),

    ZERO_NOT_DIVIDE("0은 나눌 수 없습니다."),
    NOT_DIVIDE_BY_ZERO("0으로 나눌 수 없습니다.");

    String message;

    MyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
