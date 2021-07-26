package racing.domain.car.vo;

import racing.exception.InvalidInputException;

public class Name {
    private static final int MAX_LENGTH = 5;
    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.length() > MAX_LENGTH)
            throw new InvalidInputException("자동차의 이름은 " + MAX_LENGTH + "자를 초과할 수 없습니다.");
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Name))
            return false;
        Name compareName = (Name) obj;
        return this.value.equals(compareName.value);
    }

    @Override
    public String toString() {
        return value;
    }
}
