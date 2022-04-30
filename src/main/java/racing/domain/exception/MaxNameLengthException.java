package racing.domain.exception;

public class MaxNameLengthException extends IllegalArgumentException {
    private static String MESSAGE = "이름은 5자를 초과할 수 없습니다.";

    public MaxNameLengthException() {
        super(MESSAGE);
    }
}
