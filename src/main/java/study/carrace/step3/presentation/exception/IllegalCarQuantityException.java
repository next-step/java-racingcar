package study.carrace.step3.presentation.exception;

public class IllegalCarQuantityException extends RuntimeException {
    private static final String MESSAGE = "자동차 대수는 한 대 이상이여야 합니다";

    public IllegalCarQuantityException(int carQuantity) {
        super(MESSAGE + ": " + carQuantity);
    }
}
