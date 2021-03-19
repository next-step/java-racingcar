package step4.domain;

import step4.utils.StringUtils;

public class Name {
    private static final int LIMIT_NAME_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 null이나 공백이 될 수 없습니다.");
        }
        if (name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}