package racingcar.domain.nickname;

public class CanNotOverFiveCharacterNicknameException extends RuntimeException {

    private static final String MESSAGE = "다섯자를 초과하는 닉네임은 사용할 수 없습니다.";

    public CanNotOverFiveCharacterNicknameException() {
        super(MESSAGE);
    }
}
