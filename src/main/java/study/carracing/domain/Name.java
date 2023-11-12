package study.carracing.domain;

import study.carracing.exceptions.InvalidNameException;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateNameBlank(name.trim());
        validateNameLength(name.trim());
        this.name = name;
    }

    private void validateNameBlank(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidNameException("자동차의 이름이 입력되지 않았습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameException("자동차의 이름은 5자를 초과할 수 없습니다." + name);
        }
    }

    public String getName() {
        return name;
    }
}
