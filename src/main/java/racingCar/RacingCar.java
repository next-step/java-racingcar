package racingCar;

import java.util.Objects;

public class RacingCar {
    private Position position;

    private final RacingCarName name;

    private final MoveStrategy moveStrategy;


    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        this(name, new Position(position));
    }
    public RacingCar(String name, Position position) {
        this.name = new RacingCarName(name);
        this.position = position;
        this.moveStrategy = new RandomMoveStrategy();
    }

    public void tryMove() {
        if (moveStrategy.canMove()) {
            position = position.moveForward();
        }
    }

    public boolean isFurtherAsMuchAs(RacingCar car) {
        return this.position.equals(car.position);
    }

    public static RacingCar furtherRacingCar(RacingCar one, RacingCar other) {
        if (one.position.compareTo(other.position) >= 0) {
            return one;
        }

        return other;
    }

    public RacingCarName name() {
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

    @Override
    public RacingCar clone() {
        return new RacingCar(this.name.getName(), this.position.getPosition());
    }
}
