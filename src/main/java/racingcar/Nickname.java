package racingcar;

public class Nickname {

    private static final int MAX_LENGTH = 5;
    private final String value;

    public Nickname(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validateMaxLength(value);
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
