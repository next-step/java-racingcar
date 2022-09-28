package racingcar;

public class CanNotNullNicknameException extends RuntimeException {

    private static final String MESSAGE = "null인 인자값은 nickname이 될 수 없습니다.";

    public CanNotNullNicknameException() {
        super(MESSAGE);
    }
}
