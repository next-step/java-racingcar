package car.model;

import java.util.Objects;

public class CarName {

    private static final int MAX_LENGTH = 5;
    private String name;

    public CarName(String name) {
        validateLessThanMaxLength(name.length());
        this.name = name;
    }

    private void validateLessThanMaxLength(int length) {
        if (length > MAX_LENGTH) {
            throw new IllegalArgumentException("차 이름은 항상 5를 초과해서는 안됩니다.");
        }
    }

    public String getName() {
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
