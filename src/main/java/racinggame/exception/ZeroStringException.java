package racinggame.exception;

public class ZeroStringException extends  RuntimeException {

    private static final String ZERO_INPUT_MESSAGE = "입력값은 1이상으로 입력해주세요.";

    public ZeroStringException() {
        super(ZERO_INPUT_MESSAGE);
    }
}
