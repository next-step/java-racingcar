package racing.car;

import racing.exception.InvalidInputException;
import util.StringUtils;

public class Name {
    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (!StringUtils.isEng(value))
            throw new InvalidInputException("자동차의 이름은 영어로만 입력 해주세요.");
    }

    public String getValue() {
        return value;
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
        return this.getValue().equals(compareName.getValue());
    }

    @Override
    public String toString() {
        return value;
    }
}
