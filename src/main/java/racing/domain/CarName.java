package racing.domain;

import racing.exception.CarNameLengthException;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (name.length() < 1) {
            throw new CarNameLengthException("자동차 이름은 1자 이상 5자 이하여야 합니다.", name);
        }

        if (name.length() > 5) {
            throw new CarNameLengthException("자동차 이름은 1자 이상 5자 이하여야 합니다.", name);
        }

        this.name = name;
    }
}
