package step5.racingcar3.domain;

import java.util.Objects;
import step5.racingcar3.exception.CarNameException;

public class CarName {

    private final static int MAX_LENGTH = 5;
    private final String value;

    public CarName(String carName) {
        validate(carName);
        this.value = carName.trim();
    }

    private void validate(String carName) throws CarNameException {
        if (carName.trim().length() > MAX_LENGTH) {
            throw new CarNameException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarName)) return false;
        CarName carName = (CarName) o;
        return value.equals(carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
