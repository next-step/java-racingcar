package racing.domain;

public class Car {
    private final String name;
    private int distance;
    private Movable movable;

    public Car(Movable movable) {
        this.name = "";
        this.distance = 0;
        this.movable = movable;
    }

    public int accumulateOneRound(int number) {
        this.distance += movable.moveForwardOrStop(number);
        return distance;
    }

    public int getDistance() {
        return distance;
    }
}
