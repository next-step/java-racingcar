package calculator;

public class NegativeNumberException extends RuntimeException{
    private static final String MESSAGE = "숫자만 전달 가능합니다.";

    public NegativeNumberException() {
        super(MESSAGE);
    }

}
