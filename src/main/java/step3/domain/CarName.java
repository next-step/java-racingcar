package step3.domain;

import java.util.Objects;

public class CarName {
    public static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String NAME_REGEX = "^[a-zA-Z0-9]*$";

    private final String name;

    public CarName(String name) {
        this.name = validate(name);
    }

    private String validate(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("차 이름은 알파벳 또는 숫자로만 이루어집니다");
        }

        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름 길이가 5 초과 불가");
        }

        return name;
    }

    public String getName() {
        return this.name;
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
