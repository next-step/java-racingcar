package stage4.domain;

import stage4.exception.TooLongCarNameException;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new TooLongCarNameException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
