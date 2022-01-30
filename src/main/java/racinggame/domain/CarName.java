package racinggame.domain;

import java.util.Objects;

public class CarName {

    private static final int MAX_LENGTH = 5;
    private final String name;

    public CarName(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (isBlank(name) || isOverMax(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백 문자가 아닌 5자 이하여야 합니다.");
        }
    }

    private boolean isBlank(final String name) {
        return Objects.isNull(name) || name.trim().isEmpty();
    }

    private boolean isOverMax(final String name) {
        return name.length() > MAX_LENGTH;
    }

    public String get() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
