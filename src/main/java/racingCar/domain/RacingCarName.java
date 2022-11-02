package racingCar.domain;

import java.util.Objects;

public class RacingCarName {
    public static final String CAR_NAME_MAX_LENGTH_EXCEED_ERROR = "자동차 이름은 5자 이하여야 합니다.";
    private final String name;

    public RacingCarName(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_MAX_LENGTH_EXCEED_ERROR);
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RacingCarName that = (RacingCarName) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
