package racing.domain.exception;

public class DuplicateNameException extends IllegalArgumentException {
    private static final String MESSAGE = "중복된 차 이름이 있습니다.";

    public DuplicateNameException() {
        super(MESSAGE);
    }
}
