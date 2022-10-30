package racingCar;

import java.util.Objects;

public class RacingCar {
    private Position position;

    private final String name;

    private final MoveStrategy moveStrategy;


    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        validateName(name);

        this.name = name;
        this.position = new Position(position);
        this.moveStrategy = new RandomMoveStrategy();
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void tryMove() {
        if (moveStrategy.canMove()) {
            position = position.moveForward();
        }
    }

    public boolean isFurtherAsMuchAs(RacingCar car) {
        return this.position.equals(car.position);
    }

    public boolean isFurtherOrEqualThan(RacingCar other) {
        return this.position.compareTo(other.position) >= 0;
    }

    public String name() {
        return this.name;
    }

    public RacingCarView toView() {
        return new RacingCarView(this.name, this.position);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RacingCar racingCar = (RacingCar) o;
        return position.equals(racingCar.position) && name.equals(racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
