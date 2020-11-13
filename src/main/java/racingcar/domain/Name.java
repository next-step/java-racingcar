package racingcar.domain;

public class Name {
    private final String name;

    public Name(final String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("이름 형식이 잘못 되었습니다.");
        }

        if (!isSupportFormat(name)) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    private boolean isSupportFormat(String name) {
        return name.length() <= 5;
    }

    private boolean isBlank(String name) {
        return name == null || name.trim().isEmpty();
    }

    public String getName() {
        return this.name;
    }
}
