package calculator;

public class NotNumberException extends RuntimeException{
    private static final String MESSAGE = "음수는 전달할 수 없습니다.";

    public NotNumberException() {
        super(MESSAGE);
    }

}
