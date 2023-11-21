package racingcar.domain;

public class Name {
    private final String name;

    private static final int MAX_NAME_LENGTH = 5;

    public Name(String name) {
        this.validateNameLen(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateNameLen(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 넘길 수 없습니다 : " + name);
        }
    }

    @Override
    public String toString() {
        return name + "";
    }
}
