package study.racinggame.domain.car;

public class Name {
    public static final int LENGTH_LIMIT = 5;

    private final String value;

    public Name(String name) {
        if (name.length() < 1 || name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        this.value = name;
    }

    public String getValue() {
        return value;
    }
}
