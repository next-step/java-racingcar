package racinggame.exception;

public class NameLengthOverException extends IllegalArgumentException {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String MESSAGE = String.format("자동차 이름의 글자 수는 %d자 이하입니다.",
            MAXIMUM_NAME_LENGTH);

    public NameLengthOverException(String name) {
        super(MESSAGE + " (Input: " + name + ")");
    }
}
