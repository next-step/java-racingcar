package car_racing.domain.model;

public class Name {
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name.isBlank()) throw new IllegalArgumentException("자동차 이름은 공백으로 지정할 수 없습니다.");
        if (name.length() > MAX_LENGTH) throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
