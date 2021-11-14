package racingcar.domain;

import racingcar.domain.strategy.MovingStrategy;

import java.util.Objects;

public class RacingCar {

    private final Position position;

    private final MovingStrategy strategy;

    public RacingCar(MovingStrategy strategy) {
        this(Position.ZERO_POSITION, strategy);
    }

    public RacingCar(Position position, MovingStrategy strategy) {
        this.position = position;
        this.strategy = strategy;
    }

    public Position getPosition() {
        return position;
    }

    public RacingCar move() {
        if (strategy.movable()) {
            return new RacingCar(position.move(), strategy);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(position, racingCar.position) && Objects.equals(strategy, racingCar.strategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, strategy);
    }
}
