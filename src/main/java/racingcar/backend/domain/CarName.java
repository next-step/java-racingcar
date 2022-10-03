package racingcar.backend.domain;

public class CarName {

    private static final int NAME_MAX_LENGTH = 5;
    private String value;

    public CarName(String name) {
        validateLength(name);
        this.value = name;
    }

    private void validateLength(String name) {
        if (NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
