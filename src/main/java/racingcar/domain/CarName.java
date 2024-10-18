package racingcar.domain;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        if (name.trim().length() >= MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + " 미만의 글자여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

}
