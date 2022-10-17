package racingcar.domain;

import java.util.Objects;
import racingcar.strategy.MovingStrategy;

public class Car {

    private final CarName name;
    private Position position;

    public Car(final String name) {
        this.name = new CarName(name);
        this.position = new Position(0);
    }

    public Car(final String name, final int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public void move(final MovingStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("MovingStrategy 객체가 누락되었습니다.");
        }

        this.position = this.position.increase(strategy.move());
    }

    public boolean isSamePosition(final int bound) {
        return this.position.isSameValue(bound);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position.getValue();
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
