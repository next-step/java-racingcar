package racinggame.domain;

import java.util.Objects;

public class RacingCar {

    private static final int MINIMUM_FORWARD_VALUE = 4;
    private static final int INIT_POSITION = 0;

    private final String name;
    private int position;

    public RacingCar(final String name) {
        this(name, INIT_POSITION);
    }

    public RacingCar(final String name, final int position) {
        Validator.validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    public void forward(final int number) {
        if (number >= MINIMUM_FORWARD_VALUE) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public boolean isMatchPosition(final int maxPosition) {
        return this.position == maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return position == racingCar.position && Objects.equals(name,
                racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
