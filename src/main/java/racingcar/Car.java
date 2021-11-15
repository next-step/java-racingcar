package racingcar;

public class Car {
    private int id;
    private int distance;

    public Car(int id) {
        this.id = id;
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public boolean move(int num) {
        if (num >= 4) {
            distance++;
            return true;
        }
        return false;
    }
}
