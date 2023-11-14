package car.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String carName;

    public Name(String carName) {
        validateCarNameLength(carName);
        this.carName = carName;
    }

    public String carName() {
        return this.carName;
    }

    private void validateCarNameLength(String name) {
        if (isNameEmpty(name) || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1 ~ 5 까지 입력 가능합니다.");
        }
    }

    private boolean isNameEmpty(String name) {
        return name == null || name.isBlank();
    }
}
