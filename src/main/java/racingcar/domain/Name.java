package racingcar.domain;

public class Name {

    private String name;
    private static final String MAX_CAR_NAME_VALID_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String INVALID_NAME_MESSAGE = "자동차 이름은 1자 이상이어야 합니다.";
    private static final int MAX_NAME_LENGTH = 5;

    public Name(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String names) {
        if(names == null || names.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }

        if (names.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_CAR_NAME_VALID_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
