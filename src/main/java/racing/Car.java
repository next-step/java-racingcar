package racing;

public class Car {

    private TravelDistance travelDistance;
    private Name name;

    public Car(int oldPositions, String name) {
        this.travelDistance = new TravelDistance(oldPositions);
        this.name = new Name(name);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMoveAble()) {
            travelDistance = travelDistance.move();
        }
    }

    public int getPosition() {
        return travelDistance.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}
