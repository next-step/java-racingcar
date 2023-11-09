package racingcar.domain.car;

public class Name {

    private static final int DEFAULT_CAR_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }

        if (name.length() > DEFAULT_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다. 초과된 이름 : " + name);
        }
    }
}