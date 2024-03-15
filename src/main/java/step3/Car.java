package step3;

public class Car {

    private CarName name;
    private int location;
    private MoveStrategy moveStrategy;

    Car(MoveStrategy moveStrategy) {
        this.location = 0;
        this.moveStrategy = moveStrategy;
    }

    Car(String name, MoveStrategy moveStrategy) {
        this.name = new CarName(name);
        this.location = 0;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return this.name.getName();
    }

    public int getCurrentLocation() {
        return this.location;
    }

    public void moveForwardOnChance() {
        if (moveStrategy.move()) {
            this.location += 1;
        }
    }

    public boolean isAtMaxDistance(int maxDistance) {
        return location == maxDistance;
    }
}
