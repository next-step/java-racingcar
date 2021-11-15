package racingcar;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private int id;
    private int distance;

    public Car(int id) {
        this.id = id;
        this.distance = 0;
    }

    public int getId() {
        return id;
    }

    public int getDistance() {
        return distance;
    }

    public boolean move(int num) {
        if (num >= MOVE_CONDITION) {
            distance++;
            return true;
        }
        return false;
    }
}
