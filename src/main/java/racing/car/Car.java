package racing.car;

import static racing.car.Car.MovementDistance.MOVEMENT_MAX_VALUE;
import static racing.car.Car.MovementDistance.MOVEMENT_MIN_VALUE;

public class Car {
    public enum MovementDistance {
        NOT_MOVEMENT_VALUE(0),
        MOVEMENT_MIN_VALUE(4),
        MOVEMENT_MAX_VALUE(9);

        private int value;

        MovementDistance(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Location location;
    private int moveCount;

    public Car() {
        this.location = Location.EMPTY;
        this.moveCount = 0;
    }

    public Location getLocation() {
        return location;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move(Location distance) {
        ++moveCount;
        if (distance.getValue() > MOVEMENT_MAX_VALUE.getValue())
            throw new IllegalArgumentException("최대 이동 가능한 거리는 " + MOVEMENT_MAX_VALUE + " 입니다.");
        if (distance.getValue() < MOVEMENT_MIN_VALUE.getValue())
            return;
        this.location = location.add(distance);
    }
}
