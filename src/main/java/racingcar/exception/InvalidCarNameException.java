package racingcar.exception;

public class InvalidCarNameException extends IllegalAccessException {
    private static final String ASK_AGAIN = "자동차의 이름은 5글자 이하로 입력하세요.";

    public InvalidCarNameException() {
        super(ASK_AGAIN);
    }
}
