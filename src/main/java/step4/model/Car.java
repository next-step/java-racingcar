package step4.model;

import java.util.Objects;

public class Car {

    private final static int MAXIMAL_NAME_LENGTH = 5;

    private final String name;

    public Car(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("자동차 이름은 " + MAXIMAL_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    private boolean isValidName(final String name) {
        return Objects.nonNull(name) && name.length() <= MAXIMAL_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }
}
