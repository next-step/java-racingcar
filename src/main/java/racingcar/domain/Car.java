package racingcar.domain;

import java.util.Objects;
import racingcar.strategy.NumberGenerateStrategy;

public class Car {

    private static final int AVAILABLE_MOVE_BOUND = 4;

    private CarName name;
    private int position;

    private Car() {}

    public Car(final String name) {
        this.name = new CarName(name);
    }

    public Car(final String name, final int position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position;
    }

    public void move(final NumberGenerateStrategy strategy) {
        if (strategy.generate() >= AVAILABLE_MOVE_BOUND) {
            this.position += 1;
        }
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

        return this.position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.position);
    }
}
