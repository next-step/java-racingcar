package calculator;

public class ValidateNegative extends RuntimeException {
    public static final String MESSAGE = "음수는 입력할 수 없습니다.";

    public ValidateNegative() {
        super(MESSAGE);
    }
}
