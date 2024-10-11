package racingcar.model;

public class MovingDistance {
    private static final int CAN_MOVING_FORWARD = 4;

    private int value;

    public MovingDistance(int value) {
        this.value = value;
    }

    public void increase(int randomNumber) {
        if (randomNumber >= CAN_MOVING_FORWARD) {
            this.value++;
        }
    }

    public int isLongest(int longestMovingDistance) {
        return Math.max(value, longestMovingDistance);
    }

    public boolean isSame(int longestMovingDistance) {
        return longestMovingDistance == value;
    }

    public int getValue() {
        return value;
    }

}
