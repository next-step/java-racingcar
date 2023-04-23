package racingcar.domain;

public class Car {
    public static final int MOVEABLE_POWER = 4;
    private CarName name;
    private Distance distance;

    public Car(String name, int distance) {
        this.name = new CarName(name);
        this.distance = new Distance(distance);
    }

    public Car(String name) {
        this(name, 0);
    }

    public void moveForwardOrStop(int inputPower) {
        if (inputPower >= MOVEABLE_POWER) {
            distance.move();
        }
    }

    public boolean equalsDistance(int other) {
        return distance.isEqualTo(other);
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public String getName() {
        return name.getName();
    }

}
