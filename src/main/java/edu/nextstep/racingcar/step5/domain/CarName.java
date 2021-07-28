package edu.nextstep.racingcar.step5.domain;

import edu.nextstep.racingcar.common.BusinessException;
import edu.nextstep.racingcar.step5.error.CarError;

public class CarName {

    private final String name;

    public CarName(String name) {

        if (name.length() > 5) {
            throw new BusinessException(CarError.INVALID_VALUE_TOO_LONG_CAR_NAME);
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
