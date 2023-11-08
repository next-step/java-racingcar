package racewinner.expteion;

public class NegativeNumberException extends RuntimeException {
    private final static String NEGATIVE_MSG = "시도할 횟수는 음수를 입력 할 수 없습니다.";
    public NegativeNumberException() {
        super(NEGATIVE_MSG);
    }
}