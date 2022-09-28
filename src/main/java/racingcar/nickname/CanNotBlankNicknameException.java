package racingcar.nickname;

public class CanNotBlankNicknameException extends RuntimeException {

    private static final String MESSAGE = "공백인 인자값은 nickname이 될 수 없습니다.";

    public CanNotBlankNicknameException() {
        super(MESSAGE);
    }
}
