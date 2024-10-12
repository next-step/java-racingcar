package racingcar.model;

public class MovingDistance {
    private int value;

    public MovingDistance(int value) {
        this.value = value;
    }

    public void increase(boolean isCarMoved) {
        if (isCarMoved) {
            this.value++;
        }
    }

    public int longest(int longestMovingDistance) {
        return Math.max(value, longestMovingDistance);
    }

    public boolean isSame(int longestMovingDistance) {
        return longestMovingDistance == value;
    }

    public int getValue() {
        return value;
    }

}
