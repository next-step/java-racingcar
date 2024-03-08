package error;

public enum ErrorMessage {

    ERR_NUMBER_RANGE_MESSAGE ("음수값이 입력되었습니다. 양수를 입력해 주세요."),
    ERR_NUMBER_FORMAT_MESSAGE("숫자외의 값이 입력되었습니다. 숫자를 입력해 주세요") ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String print() {
        return this.message;
    }
}
