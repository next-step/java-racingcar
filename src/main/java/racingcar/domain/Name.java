package racingcar.domain;

import racingcar.util.ValidateUtils;

public class Name {
    private static final String OUT_OF_NAME_SIZE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    public Name(String name) {
        validMaxSize(name);
        this.name = name;
    }

    private void validMaxSize(String name) {
        ValidateUtils.validateEmpty(name);
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(OUT_OF_NAME_SIZE);
        }
    }

    public String getName() {
        return this.name;
    }
}
