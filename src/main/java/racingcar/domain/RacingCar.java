package racingcar.domain;

import racingcar.domain.movingstrategy.MovingStrategy;

import java.util.Objects;

public class RacingCar implements Cloneable {

    private RacingCarName name;
    private Position position;
    private final MovingStrategy movingStrategy;

    public RacingCar(RacingCarName name, MovingStrategy movingStrategy) {
        this.name = name;
        this.movingStrategy = movingStrategy;
        this.position = new Position();
    }

    public void move() {
        if (movingStrategy.movable()) {
            position.forward();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
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
