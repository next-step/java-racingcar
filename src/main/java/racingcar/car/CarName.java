package racingcar.car;

public class CarName {

    private static final String MESSAGE_EMPTY_CAR_NAME = "자동차 이름은 한 글자 이상이어야 합니다.";
    private static final String MESSAGE_INVALID_CAR_NAME_LENGTH = "자동차의 이름은 5자를 초과할 수 없습니다.";
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException(MESSAGE_EMPTY_CAR_NAME);
        }

        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(MESSAGE_INVALID_CAR_NAME_LENGTH);
        }
    }

    private boolean isBlank(String name) {
        if (name == null || name.isEmpty()) {
            return true;
        }
        return name.trim().isEmpty();
    }

}
