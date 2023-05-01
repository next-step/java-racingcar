package carracing.domain;

import static carracing.utile.StringUtile.trim;

public class Name {
    private final String name;

    public Name(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }

        this.name = trim(name);
    }

    public String getName() {
        return name;
    }
}
