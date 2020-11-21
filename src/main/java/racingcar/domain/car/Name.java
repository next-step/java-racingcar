package racingcar.domain.car;

import racingcar.util.StringUtils;

public class Name {

    private static final int LIMIT_LENGTH = 5;
    private final String value;

    public Name(String value) {
        validName(value);
        validNameLength(value);
        this.value = value;
    }

    private void validName(String value) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("the name must not blank.");
        }
    }

    private void validNameLength(String value) {
        if (value.length() > LIMIT_LENGTH) {
            throw new IllegalArgumentException("the name must be less than five characters.");
        }
    }

    public String getValue() {
        return value;
    }
}
