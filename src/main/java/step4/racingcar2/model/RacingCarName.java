package step4.racingcar2.model;

import step4.racingcar2.exception.RacingCarNameException;

public class RacingCarName {

    private final static int MAX_LENGTH = 5;
    private final String value;

    public RacingCarName(String carName) {
        validate(carName);
        this.value = carName;
    }

    private void validate(String carName) throws RacingCarNameException {
        if (carName.length() > MAX_LENGTH) {
            throw new RacingCarNameException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public String value() {
        return this.value;
    }
}
