package stage4.domain;

import stage4.exception.TooLongCarNameException;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateEmpty(name);
        validateLength(name);
        this.name = name;
    }

    public CarName(CarName carName) {
        validateEmpty(carName.name);
        validateLength(carName.name);
        this.name = carName.name;
    }

    private void validateEmpty(String name) {
        if (name.isEmpty() || name.equals(" ")) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            throw new TooLongCarNameException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public String getName() {
        return this.name;
    }
}
