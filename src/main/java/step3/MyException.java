package step3;

public enum MyException {

    IS_NOT_NUMBER("정수가 아닙니다."),
    VALUE_GREATER_THAN_ONE("1 이상의 값을 입력해주세요.");

    private final String message;

    MyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
