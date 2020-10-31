package stringCalculator.exception;

public class NullException extends IllegalArgumentException {

    public NullException() {
        super("NULL을 사용할 수 없습니다.");
    }
}
