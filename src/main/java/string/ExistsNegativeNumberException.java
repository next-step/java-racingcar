package string;

public class ExistsNegativeNumberException extends RuntimeException {
    private static final String MESSAGE = "구분자 사이에 음수는 포함될 수 없습니다.";

    public ExistsNegativeNumberException() {
        super(MESSAGE);
    }
}
