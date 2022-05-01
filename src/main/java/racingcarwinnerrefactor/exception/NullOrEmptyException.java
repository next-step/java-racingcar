package racingcarwinnerrefactor.exception;

public class NullOrEmptyException extends RuntimeException{
    private static final String MESSAGE = "비어있거나 NULL인 경우 자동차를 생성할 수 없습니다.";
    public NullOrEmptyException() {
        super(MESSAGE);
    }
}
