package racingcar.domain.value;

import racingcar.service.util.Validation;

public class CarName {

    private final String name;

    private CarName(String name) {

        Validation.nameSizeCheck(name);

        this.name = name;
    }

    public static CarName create(String name) {

        return new CarName(name);
    }

    public String getName() {

        return name;
    }
}
