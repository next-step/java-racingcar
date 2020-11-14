package racing;

public class Car {

    private TravelDistance travelDistance;

    public Car() {
        this.travelDistance = new TravelDistance();
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
