package racing;

public class Car {

    private TravelDistance travelDistance;

    public Car(int oldPositions) {
        this.travelDistance = new TravelDistance(oldPositions);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMoveAble()) {
            travelDistance = travelDistance.move();
        }
    }

    public int getPosition() {
        return travelDistance.getPosition();
    }
}
