package racingcar.domain;

public class Name {

    private final String value;

    private Name(final String value) {
        if (value.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 넘을 수 없습니다.");
        }
        this.value = value;
    }

    public static Name from(final String name) {
        return new Name(name);
    }

    @Override
    public String toString() {
        return value;
    }
}
