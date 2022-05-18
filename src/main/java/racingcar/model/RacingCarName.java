package racingcar.model;

public class RacingCarName {
    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private final String value;

    public RacingCarName(String value) {
        this.value = validation(value);
    }

    public String getValue() {
        return this.value;
    }

    private String validation(String name) {
        if (name.length() > 5) {
            throw new IllegalStateException(NAME_LENGTH_ERROR_MESSAGE);
        }

        return name;
    }
}
