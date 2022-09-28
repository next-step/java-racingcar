package racingcar.nickname;

public class Nickname {

    private static final int MAX_LENGTH = 5;
    private final String value;

    public Nickname(String value) {
        validateNull(value);
        value = value.trim();
        validate(value);
        this.value = value;
    }

    private void validateNull(String value) {
        if(value == null) {
            throw new CanNotNullNicknameException();
        }
    }

    private void validate(String value) {
        validateBlank(value);
        validateMaxLength(value);
    }

    private void validateBlank(String value) {
        if(value.isBlank()) {
            throw new CanNotBlankNicknameException();
        }
    }

    private void validateMaxLength(String value) {
        if(value.length() > MAX_LENGTH) {
            throw new CanNotOverFiveCharacterNicknameException();
        }
    }

    public String getValue() {
        return this.value;
    }
}
