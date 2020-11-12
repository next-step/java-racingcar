package racing;

public class Car {

    private int travelDistance = 0;

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMoveAble()) {
            travelDistance++;
        }
    }

    public int getTravelDistance() {
        return travelDistance;
    }
}
