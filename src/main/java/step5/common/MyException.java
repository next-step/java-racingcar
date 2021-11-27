package step5.common;

public enum MyException {
    VALUE_GREATER_THAN_ZERO("위치는 0 이상만 가능합니다."),
    VALUE_GREATER_THAN_ONE("1 이상의 값을 입력해주세요."),
    INVALID_NAME_LENGTH("자동차 이름은 1~5자 사이로 입력해주세요."),
    NAME_IS_NOT_NULL("자동차 이름은 필수입니다."),
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
