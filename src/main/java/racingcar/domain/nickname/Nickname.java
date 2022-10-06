package racingcar.domain.nickname;

import java.util.Objects;

public class Nickname {

    private static final int MAX_LENGTH = 5;

    private final String value;

    public Nickname(final String value) {
        validateNull(value);
        String trimmedValue = value.trim();
        validate(trimmedValue);
        this.value = trimmedValue;
    }

    private void validateNull(String value) {
        if (value == null) {
            throw new CanNotNullNicknameException();
        }
    }

    private void validate(String value) {
        validateBlank(value);
        validateMaxLength(value);
    }

    private void validateBlank(String value) {
        if (value.isBlank()) {
            throw new CanNotBlankNicknameException();
        }
    }

    private void validateMaxLength(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new CanNotOverFiveCharacterNicknameException();
        }
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nickname nickname = (Nickname) o;
        return Objects.equals(value, nickname.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
