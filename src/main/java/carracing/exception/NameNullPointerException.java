package carracing.exception;

public class NameNullPointerException extends NullPointerException {

    private static final String NAME_NULL_POINTER_EXCEPTION = "자동차 이름은 필수 입니다.";

    public NameNullPointerException() {
        super(NAME_NULL_POINTER_EXCEPTION);
    }

}
