package utils.exception;

public class CarNameAtLeastOneCommaWhenSplitException extends RuntimeException {
    public CarNameAtLeastOneCommaWhenSplitException() {
        super("입력시 (,)를 최소 1번 이상 입력하셔야 합니다.");
    }

    public CarNameAtLeastOneCommaWhenSplitException(String message) {
        super(message);
    }
}
