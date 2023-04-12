package step3.domain;

public class Car {
    private int distance = 0;

    public void tryMove(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.distance += 1;
        }
    }

    public int getDistance() {
        return this.distance;
    }
}
