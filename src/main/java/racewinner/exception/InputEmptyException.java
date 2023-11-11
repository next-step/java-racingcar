package racewinner.exception;

public class InputEmptyException extends RuntimeException {
    private final static String INPUT_EMPTY_MSG = "빈 값을 입력 할 수 없습니다.";
    public InputEmptyException() {
        super(INPUT_EMPTY_MSG);
    }
}
