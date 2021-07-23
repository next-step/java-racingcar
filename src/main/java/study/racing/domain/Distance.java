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
}
