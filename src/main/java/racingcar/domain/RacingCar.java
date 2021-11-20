package racingcar.domain;

import racingcar.domain.strategy.MovingStrategy;

import java.util.Objects;

public class RacingCar {

    private final Name name;

    private final Position position;

    private final MovingStrategy strategy;

    public RacingCar(Name name, MovingStrategy strategy) {
        this(name, Position.ZERO_POSITION, strategy);
    }

    public RacingCar(Name name, Position position, MovingStrategy strategy) {
        this.name = name;
        this.position = position;
        this.strategy = strategy;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public RacingCar move() {
        if (strategy.movable()) {
            return new RacingCar(name, position.move(), strategy);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name) && Objects.equals(position, racingCar.position) && Objects.equals(strategy, racingCar.strategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, strategy);
    }
}
