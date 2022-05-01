package racingcarwinnerrefactor.exception;

public class NameSizeException extends RuntimeException{
    private static final String MESSAGE = "5글자를 넘는 이름은 입력할 수 없습니다.";

    public NameSizeException() {
        super(MESSAGE);
    }
}
