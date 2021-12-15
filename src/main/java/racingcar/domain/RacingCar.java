package racingcar.domain;

import racingcar.domain.movingstrategy.MovingStrategy;

import java.util.Objects;

public class RacingCar implements Cloneable {

    private final RacingCarName name;
    private final MovingStrategy movingStrategy;
    private Position position;

    public RacingCar(RacingCarName name, MovingStrategy movingStrategy) {
        this(name, new Position(), movingStrategy);
    }

    public RacingCar(RacingCarName name, Position position, MovingStrategy movingStrategy) {
        this.name = name;
        this.position = position;
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        if (movingStrategy.movable()) {
            position = position.forward();
        }
    }

    public boolean isInPosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name) &&
                Objects.equals(position, racingCar.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    protected RacingCar clone() throws CloneNotSupportedException {
        RacingCar racingCar = (RacingCar)super.clone();
        racingCar.position = (Position)racingCar.position.clone();
        return racingCar;
    }

    public Position getPosition() {
        return position;
    }

    public RacingCarName getName() {
        return name;
    }

}
