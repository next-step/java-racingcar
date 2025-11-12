package racingCar;

public class Car {
    private static final int LIMIT_NUM = 4;
    private int distance;
    private String name;

    public Car() {
        this.distance = 0;
    }

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }
    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void move(int dis) {
        if (isMoveable(dis)) {
            this.distance++;
        }
    }

    private boolean isMoveable(int dis) {
        return dis >= LIMIT_NUM;
    }
}
