package racingcar.domain;

import java.util.Objects;

public class RacingCar {
    public static final int LEAST_MOVE_CONDITION = 4;
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

    public String getCarName() {
        return this.name.getName();
    }

    public long getPosition() {
        return this.position.getNumber();
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
