package stage2.stringcalculator.exception;

public class InvalidArithmeticOperatorException extends IllegalArgumentException {
    public InvalidArithmeticOperatorException() {
        super("입력 값이 null이거나 빈 공백 문자 입니다.");
    }
}
