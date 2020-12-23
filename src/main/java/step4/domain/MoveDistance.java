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

    public int getMoveDistance() {
        return moveDistance;
    }
}


