package racinggame.domain;

import racinggame.utils.StringUtils;

public class Name {
    private final String name;

    public Name(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }

        if (name.length() < 0 || name.length() > 5) {
            throw new IllegalArgumentException("이름이 유효하지 않습니다.");
        }

        this.name = name;
    }
}
