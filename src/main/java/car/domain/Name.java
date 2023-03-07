package car.domain;

public class Name {

    private static final int LIMIT_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() >= LIMIT_LENGTH) {
            String message = String.format("자동차 이름은 %d자 미만만 가능 합니다. name = %s", LIMIT_LENGTH, name);
            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
