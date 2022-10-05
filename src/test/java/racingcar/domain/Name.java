package racingcar.domain;

import org.assertj.core.util.Strings;

public class Name {
    public static final int MAXIMUM_LENGTH = 5;

    public Name(String name) {
        validateNullOrEmpty(name);
        validateOverMaximumLength(name);
    }

    private void validateOverMaximumLength(String name) {
        if (name.length() <= MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없다.");
        }
    }

    private void validateNullOrEmpty(String name) {
        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("자동차 이름은 1글자 보다 작을 수 없다.");
        }
    }
}
