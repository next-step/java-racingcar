package racingcar.view;

public class InputValidator {
    public static final String INVALID_INPUT_ERROR_MESSAGE = "입력한 숫자는 0 보다 커야 합니다.";
    public static final int MIN_VALUE = 1;

    private InputValidator() {
    }

    public static int validateInput(int count) {
        if(count < MIN_VALUE) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
        return count;
    }
}
