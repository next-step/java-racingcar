package racingCar;

import java.util.Objects;

public class CarName {

    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    public CarName(String name) {
        validName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validName(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다");
        }
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
