package racingcar.domain;

import java.util.Objects;
import racingcar.domain.strategy.MoveStrategy;

public class RacingCar implements Car {

    private static final int START_POSITION = 0;

    private final Name name;
    private int position;

    public RacingCar(Name name) {
        this(name, START_POSITION);
    }

    public RacingCar(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (!moveStrategy.isMoveable()) {
            return;
        }
        position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RacingCar)) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}