package carracing.model;

import static carracing.RacingGameSetupValidator.isValidLengthString;

public class NameOfCar {
    private static final String WRONG_CAR_NAME_MESSAGE = "null 또는 공백 또는 5자를 초과하는 이름은 자동차 이름으로 사용할 수 없습니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private NameOfCar(final String name) {
        if (!isValidLengthString(name, MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException(WRONG_CAR_NAME_MESSAGE);
        }
        this.name = name;
    }

    public static NameOfCar newName(final String name) {
        return new NameOfCar(name);
    }

    public String carName() {
        return name;
    }
}
