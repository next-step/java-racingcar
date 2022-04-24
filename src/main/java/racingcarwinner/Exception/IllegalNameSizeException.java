package racingcarwinner.Exception;

public class IllegalNameSizeException extends RuntimeException{
    private static final String EXCEPTION_MESSAGE = "자동차의 이름은 5글자를 초과할 수 없습니다.";
    public IllegalNameSizeException() {
        super(EXCEPTION_MESSAGE);
    }
}
