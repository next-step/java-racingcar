package game.domain;

import java.util.Objects;

public class Distance {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 0;
    private static final int MINIMUM_MOVEMENT_NUMBER = 4;
    private int distance;

    public Distance(int distance) {
        validateNumber(distance);
        this.distance = distance;
    }

    public void move(int number) {
        validateNumber(number);
        if (canMove(number)) {
            distance += 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distance)) return false;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    private void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new RuntimeException();
        }
    }

    private boolean canMove(int number) {
        return number >= MINIMUM_MOVEMENT_NUMBER;
    }

    public int getDistance() {
        return this.distance;
    }
}
