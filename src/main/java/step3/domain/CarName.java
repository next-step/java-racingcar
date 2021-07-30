package step3.domain;

import step3.exception.WrongGameSettingException;

public class CarName {

    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new WrongGameSettingException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String value() {
        return this.carName;
    }

}
