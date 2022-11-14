package race.domian;

public class Name {
    private final String name;

    private static final String CHARACTER_LIMIT_ERROR = "이름은 5자를 초과할 수 없습니다.";
    private static final int CHARACTER_LIMIT = 5;

    public Name(String name) {
        if (name.length() > CHARACTER_LIMIT) {
            throw new IllegalArgumentException(CHARACTER_LIMIT_ERROR);
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");

        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
