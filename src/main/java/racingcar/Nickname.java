package racingcar;

public class Nickname {

    private static final int MAX_LENGTH = 5;
    private final String value;

    public Nickname(String value) {
        validateNull(value);
        value = removeBlank(value);
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validateMaxLength(value);
    }

    private void validateNull(String value) {
        if(value == null) {
            throw new CanNotNullNicknameException();
        }
    }

    private String removeBlank(String value) {
        return value.trim();
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
