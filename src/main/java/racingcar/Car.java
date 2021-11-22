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
        this(id, movable, name, 1);
    }

    public Car(int id, Movable movable, CarName name, int distance) {
        this.id = id;
        this.distance = distance;
        this.movable = movable;
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return name.get();
    }

    public void move(int num) {
        if (movable.move(num)) {
            distance++;
        }
    }

    public boolean isWinner(int maxDistance) {
        return distance == maxDistance;
    }
}
