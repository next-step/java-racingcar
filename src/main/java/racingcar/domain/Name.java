package racingcar.domain;

public class Name {
    private final String name;
    private static final int NAME_LENGTH = 5;

    public Name(final String name) {
        valid(name);
        this.name = name;
    }

    private void valid(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("이름 형식이 잘못 되었습니다.");
        }

        if (!isSupportFormat(name)) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private boolean isSupportFormat(String name) {
        return name.length() <= NAME_LENGTH;
    }

    private boolean isBlank(String name) {
        return name == null || name.trim().isEmpty();
    }

    public String getName() {
        return this.name;
    }
}
