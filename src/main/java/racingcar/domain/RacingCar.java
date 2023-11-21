package racingcar.domain;

import static racingcar.constant.Constant.MOVE_DISTANCE_EXPRESSION;
import static racingcar.constant.Constant.DEFAULT_POSITION;
import static racingcar.constant.Constant.LEAST_MOVE_CONDITION;

import java.util.Objects;

public class RacingCar {
    private final CarName name;
    private Position position;

    public RacingCar(String name, long position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public RacingCar(String name) {
        this(name, 0);
    }

    public void move(int randomNumber) {
        if (movable(randomNumber)) {
            this.position = position.move();
        }
    }

    private boolean movable(int randomNumber) {
        return randomNumber >= LEAST_MOVE_CONDITION;
    }

    public String movingDistance() {
        return MOVE_DISTANCE_EXPRESSION.repeat(position.sizeComparison(DEFAULT_POSITION));
    }

    public String getCarName() {
        return this.name.getName();
    }

    public long updateMaxPosition(long maxPosition) {
        return this.position.compare(maxPosition);
    }

    public boolean isLocated(long finishLine) {
        return this.position.isSame(finishLine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(position, racingCar.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
