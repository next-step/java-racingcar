package stringCalculator.exception;

public class EmptyInputException extends IllegalArgumentException{
    public EmptyInputException() {
        super("입력 값이 비어 있습니다.");
    }
}
