package racingcarwinnerrefactor.exception;

public class NumberException extends RuntimeException{
    private static final String MESSAGE = "음수는 입력될 수 없습니다.";

    public NumberException() {
        super(MESSAGE);
    }
}
