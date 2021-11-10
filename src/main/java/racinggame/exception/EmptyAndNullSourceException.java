package racinggame.exception;

public class EmptyAndNullSourceException extends RuntimeException {

    private static final String INVALID_SOURCE_MESSAGE = "공백은 입력할 수 없습니다.";

    public EmptyAndNullSourceException() {
        super(INVALID_SOURCE_MESSAGE);
    }
}
