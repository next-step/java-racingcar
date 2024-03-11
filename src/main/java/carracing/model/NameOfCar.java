package carracing.model;

import static carracing.RacingGameSetupValidator.isNonBlank;

public class NameOfCar {
    private static final String WRONG_CAR_NAME_MESSAGE = "null 또는 공백 또는 5자를 초과하는 이름은 자동차 이름으로 사용할 수 없습니다.";
    private static final int NAME_LENGTH_LIMIT = 5;
    private final String name;

    private NameOfCar(String name) {
        if(!isNonBlank(name) || name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(WRONG_CAR_NAME_MESSAGE);
        }
        this.name = name;
    }

    public static NameOfCar newCarName(String name) {
        return new NameOfCar(name);
    }

    public String carName() {
        return name;
    }
}
