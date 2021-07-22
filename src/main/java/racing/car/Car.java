package racing.car;

import java.util.Objects;

public class Car {
    public enum MovementLimitDistance {
        MIN_VALUE(4), MAX_VALUE(9);

        private int value;

        MovementLimitDistance(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Location location;

    public Car() {
        this.location = Location.EMPTY;
    }

    public Location getLocation() {
        return location;
    }

    public void move(Location distance) {
        if (Objects.isNull(distance) || distance.getValue() < MovementLimitDistance.MIN_VALUE.getValue())
            return; // 4이하의 distance을 받을 경우 exception을 throw 하는게 좋을까요?
        this.location = location.add(distance);
    }
}
