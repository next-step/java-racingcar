package racing.domain.exception;

public class MaxNumberException extends IllegalArgumentException{
    private static final String MESSAGE = "값은 10를 초과할 수 없습니다.";

    public MaxNumberException() {
        super(MESSAGE);
    }
}
