package racing.car;

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
        this.location = location.add(distance);
    }
}
