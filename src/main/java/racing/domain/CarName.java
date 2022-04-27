package racing.domain;

import java.util.Objects;

public class CarName {
    private static final String EXCEPTION_EXCEED_LIMIT_MESSAGE = "자동차 이름은 5글자를 초과하지 않아야합니다";
    private static final String EXCEPTION_INVALID_MESSAGE = "자동차 이름은 빈 값이거나 null일 수 없습니다";
    private final String name;

    public CarName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_MESSAGE);
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(EXCEPTION_EXCEED_LIMIT_MESSAGE);
        }

        this.name = name;
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
        return getName().equals(carName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
