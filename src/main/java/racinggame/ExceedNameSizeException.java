package racinggame;

public class ExceedNameSizeException extends RuntimeException {
    private static final String MESSAGE = "자동차의 이름은 5자 이하만 입력 가능합니다.";

    public ExceedNameSizeException() {
        super(MESSAGE);
    }

}
