package racingcar.domain;

import java.util.Objects;
import racingcar.strategy.NumberGenerateStrategy;

public class Car {

    private static final int AVAILABLE_MOVE_BOUND = 4;

    private CarName name;
    private Position position;

    public Car(final String name) {
        this.name = new CarName(name);
        this.position = new Position(0);
    }

    public Car(final String name, final int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public void move(final NumberGenerateStrategy strategy) {
        if (strategy.generate() >= AVAILABLE_MOVE_BOUND) {
            this.position = this.position.increase(1);
        }
    }

    public boolean isSamePosition(final int bound) {
        return this.position.isSameNumber(bound);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Car)) {
            return false;
        }

        final Car that = (Car) o;

        if (!this.name.equals(that.name)) {
            return false;
        }

        return this.position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.position);
    }
}
