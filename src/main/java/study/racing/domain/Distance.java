package study.racing.domain;

public class Distance {

    private int moveDistance;

    public Distance() {
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void move() {
        moveDistance += 1;
    }

    public int getMaxValue(int max) {
        return Math.max(moveDistance,max);
    }

    public boolean isMax(Distance distance, int max) {
        return distance.getMoveDistance() > max;
    }
}
