package racinggame.domain;

import java.util.Objects;

public class RacingCar {

    private static final int MINIMUM_FORWARD_VALUE = 4;
    private static final int INIT_POSITION = 0;

    private String name;
    private int position;

    public RacingCar(String name) {
        this(name, INIT_POSITION);
    }

    public RacingCar(String name, int position) {
        Validator.validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    public boolean canForward(int randomValue) {
        return randomValue >= MINIMUM_FORWARD_VALUE;
    }

    public void forward() {
        this.position += 1;
    }

    public int getPosition() {
        return this.position;
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
        RacingCar racingCar = (RacingCar) o;
        return position == racingCar.position && Objects.equals(name,
                racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public boolean isMatchPosition(int maxPosition) {
        return this.position == maxPosition;
    }
}
