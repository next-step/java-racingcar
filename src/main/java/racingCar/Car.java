package racingCar;

public class Car {

    private final MovableStrategy movableStrategy;

    private String distance = "";

    public Car (MovableStrategy movableStrategy) {
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
}
