package racingCar.domain;

import racingCar.domain.validator.CarNameValidator;

public class CarName {
    private final String name;

    public CarName(String name) {
        this.name = name;
    }

    public static CarName from(String name) {
        CarNameValidator.validate(name);
        return new CarName(name);
    }

    public String getName() {
        return name;
    }
}
