package step4.domain;

public class MoveDistance {

    private int moveDistance;

    public MoveDistance() {
    }

    public MoveDistance(int moveDistance) {
        this.moveDistance = moveDistance;
    }

    public void move() {
        moveDistance += 1;
    }

    public boolean isSamePosition(int maxPosition) {
        return this.moveDistance == maxPosition;
    }

    public int isMaxPosition(int maxPosition) {
        return Math.max(moveDistance, maxPosition);
    }

    public int getMoveDistance() {
        return moveDistance;
    }
}


