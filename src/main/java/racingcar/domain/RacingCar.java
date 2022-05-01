package racingcar.domain;

import java.util.Objects;

public class RacingCar {
    private static final int MOVE_UNIT = 1;
    private static final int MOVE_CONDITION = 4;

    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
    }

    public RacingCar(String name, int position) {
        this.position = position;
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber > MOVE_CONDITION) {
            position += MOVE_UNIT;
        }
    }

    public int maxPosition(int maxPosition) {
        return Math.max(position, maxPosition);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) obj;
        return this.name.equals(racingCar.name) && this.position == racingCar.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
