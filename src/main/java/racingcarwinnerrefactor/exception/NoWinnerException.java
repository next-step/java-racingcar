package racingcarwinnerrefactor.exception;

public class NoWinnerException extends RuntimeException{
    private static final String MESSAGE = "우승자가 존재하지 않습니다.";
    public NoWinnerException() {
        super(MESSAGE);
    }
}
