package step4.common;

public enum MyException {
    VALUE_GREATER_THAN_ZERO("0 이상의 값을 입력해주세요."),
    INVALID_NAME_LENGTH("이름은 1~5자 사이로 입력해주세요."),
    NAME_IS_NOT_NULL("이름은 필수입니다."),
    NUMBER_IS_INTEGER("정수값을 입력해주세요.")
    ;

    private final String message;

    MyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
