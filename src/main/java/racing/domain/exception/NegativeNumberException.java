package racing.domain.exception;

public class NegativeNumberException extends IllegalArgumentException {
    private static final String MESSAGE = "값은 음수가 될 수 없습니다.";

    public NegativeNumberException() {
        super(MESSAGE);
    }
}
