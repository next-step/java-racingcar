package racingcar.domain.car;

import java.util.Objects;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isNotValidName(name)) {
            throw new IllegalArgumentException(String.format("name(%s)이 올바르지 않습니다.", name));
        }
    }

    private boolean isNotValidName(String name) {
        return name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(getName(), carName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
