package step4.common;

public enum MyException {
    VALUE_GREATER_THAN_ONE("1 이상의 값을 입력해주세요."),
    INVALID_NAME_LENGTH("이름은 1~5자 사이로 입력해주세요.");

    private final String message;

    MyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
