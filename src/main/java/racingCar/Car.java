package racingCar;

public class Car {

    private final MovableStrategy movableStrategy;

    private CarName name;
    private String distance = "";

    public Car(String name, MovableStrategy movableStrategy) {
        this.name = new CarName(name);
        this.movableStrategy = movableStrategy;
    }

    public String move(int value) {
        if (movableStrategy.canMove(value)) {
            this.distance += "-";
            return "-";
        }

        return "";
    }

    public String getDistance() {
        return this.distance;
    }

    public String getName() {
        return name.getName();
    }
}
