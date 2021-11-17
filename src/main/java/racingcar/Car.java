package racingcar;

public class Car {
    private int id;
    private int distance;
    private Movable movable;

    public Car(int id, Movable movable) {
        this.id = id;
        this.distance = 1;
        this.movable = movable;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int num) {
        if (movable.move(num)) {
            distance++;
        }
    }
}
