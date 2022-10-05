package racinggame.domain.embeded;

import calculator.StringUtils;

import java.util.Objects;

public class CarName {

    public static final int MAX_NAME_LENGTH = 4;
    private final String name;

    public CarName(String name) {
        if (isInValidName(name)) {
            throw new IllegalArgumentException("이름은 4글자 이하만 가능합니다.");
        }
        this.name = name;
    }

    private boolean isInValidName(String name) {
        return (StringUtils.isEmpty(name) || name.length() > MAX_NAME_LENGTH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarName carName1 = (CarName) o;

        return Objects.equals(name, carName1.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
