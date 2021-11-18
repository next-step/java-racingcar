package racingcar;

public class Car {
    private int id;
    private int distance;
    private Movable movable;
    private CarName name;

    public Car(int id, Movable movable) {
        this(id, movable, new CarName(""));
    }

    public Car(int id, Movable movable, CarName name) {
        this.id = id;
        this.distance = 1;
        this.movable = movable;
        this.name = name;
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
