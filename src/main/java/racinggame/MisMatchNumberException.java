package racinggame;

public class MisMatchNumberException extends RuntimeException {
    private static final String MESSAGE = "숫자 형식의 값만 입력할 수 있습니다.";

    public MisMatchNumberException() {
        super(MESSAGE);
    }

}
