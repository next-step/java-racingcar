package step5.racingcar3.domain;

import step5.racingcar3.exception.CarNameException;

public class CarName {

    private final static int MAX_LENGTH = 5;
    private final String value;

    public CarName(String carName) {
        validate(carName);
        this.value = carName;
    }

    private void validate(String carName) throws CarNameException {
        if (carName.length() > MAX_LENGTH) {
            throw new CarNameException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public String value() {
        return this.value;
    }
}
