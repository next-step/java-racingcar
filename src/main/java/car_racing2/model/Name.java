package car_racing2.model;

public class Name {
    private static final int NAME_LENGTH_LIMIT = 5;
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank()) throw new IllegalArgumentException("자동차의 이름은 공백으로 할 수 없습니다.");
        if (name.length() > NAME_LENGTH_LIMIT) throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
