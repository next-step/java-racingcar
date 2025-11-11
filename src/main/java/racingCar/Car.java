package racingCar;

public class Car {
    private int distance;
    private static final int LIMIT_NUM = 4;

    public Car() {
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    public void move(int dis) {
        if (checkDis(dis)) {
            this.distance++;
        }
    }

    private boolean checkDis(int dis) {
        return dis >= LIMIT_NUM;
    }
}
