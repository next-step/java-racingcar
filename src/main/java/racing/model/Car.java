package racing.model;

public class Car {
    private Position position;
    private final CarName name;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new Position();
    }

    public void goForward() {
        this.position = this.position.goForward();
    }

    public boolean isPositionValue(int positionValue) {
        return this.position.isSamePosition(positionValue);
    }

    public int getPosition() {
        return this.position.getValue();
    }

    public String getName() {
        return this.name.getName();
    }
}
