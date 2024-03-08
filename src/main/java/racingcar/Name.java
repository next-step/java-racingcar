package racingcar;

public class Name {

    private final String name;

    public Name(String name) {
        assertValidName(name);
        this.name = name.trim();
    }

    private void assertValidName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다");
        }
        name = name.trim();
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다");
        }
    }

    public String name() {
        return name;
    }
}
