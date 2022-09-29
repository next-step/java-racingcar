package racingcar.domain;

import java.util.Objects;

public class RacingCar {

    private final int MOVE_LENGTH = 1;

    private final RacingCarName name;
    private Position position;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        this.name = new RacingCarName(name);
        this.position = new Position(position);
    }

    public void move(MoveCondition moveCondition) {
        if (moveCondition.canMove()) {
            this.position = new Position(position, MOVE_LENGTH);
        }
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return name.getValue();
    }

    public boolean isEqualsPosition(int position) {
        return this.position.getValue() == position;
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

        if (!Objects.equals(name, racingCar.name)) {
            return false;
        }
        return Objects.equals(position, racingCar.position);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
