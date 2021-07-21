package calculator.exception;

public class InvalidFormulaException extends RuntimeException {

    private static final String MESSAGE = "유효하지 않은 수식입니다.";

    public InvalidFormulaException() {
        super(MESSAGE);
    }
}
