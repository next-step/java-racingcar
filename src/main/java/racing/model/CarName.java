package racing.model;

import exception.EmptyCarNameException;
import exception.InvalidCarNameSizeException;

public class CarName {
    private static final int LENGTH_LIMIT = 5;
    private final String name;

    public CarName(String name) {
        validName(name);
        this.name = name;
    }

    private void validName(String name) {
        if (name.isEmpty()) {
            throw new EmptyCarNameException("공백 자동차 이름은 허용하지 않습니다.");
        }
        if (name.length() > LENGTH_LIMIT) {
            throw new InvalidCarNameSizeException("자동차 이름이 적합하지 않습니다. 이름 : " + name);
        }
    }

    public String getName() {
        return name;
    }
}
