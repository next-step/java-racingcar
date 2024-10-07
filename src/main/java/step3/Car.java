package step3;

public class Car {

    private int distance;

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            distance++;
        }
    }

    public int showDistance() {
        return distance;
    }
}
