package study.racing.domain;

public class Distance {

    private static final int DEFAULT_DISTANCE = 0;

    int moveDistance;

    public Distance(int moveDistance) {
        this.moveDistance = moveDistance;
    }

    public Distance() {
        this.moveDistance = DEFAULT_DISTANCE;
    }

    public int getMove() {
        return moveDistance;
    }

    public void move() {
        moveDistance += 1;
    }
}
