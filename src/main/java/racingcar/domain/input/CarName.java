package racingcar.domain.input;

import racingcar.domain.input.exception.MaximumCarNameException;
import racingcar.domain.input.exception.RequiredCarNameException;

public class CarName {

    private static final int MAX_LENGTH_CAR_NAME = 5;
    private String carName;

    public CarName(String carName) {
        if (isNullOrBlank(carName)) {
            throw new RequiredCarNameException();
        }
        if (isOverMaxLength(carName)) {
            throw new MaximumCarNameException();
        }
        this.carName = carName;
    }

    private boolean isOverMaxLength(String carName) {
        return carName.length() > MAX_LENGTH_CAR_NAME;
    }

    private boolean isNullOrBlank(String carName) {
        return carName == null || carName.isBlank();
    }

    public String getCarName() {
        return this.carName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CarName)) {
            return false;
        }
        CarName cn = (CarName) obj;
        return cn.carName.equals(carName);
    }
}
