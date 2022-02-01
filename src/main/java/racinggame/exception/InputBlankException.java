package racinggame.exception;

public class InputBlankException extends IllegalArgumentException {

    private static final String MESSAGE = "값이 입력되지 않았습니다.";

    public InputBlankException() {
        super(MESSAGE);
    }

    public InputBlankException(int index) {
        super(MESSAGE + " (" + index + "번째 자동차 이름이 공백입니다.)");
    }
}
