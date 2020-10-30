package step2.exception;

public class NullException extends IllegalArgumentException {
    public NullException() {
        super("널을 삽입할 수 없습니다.");
    }
}
