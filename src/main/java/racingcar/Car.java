package racingcar;

public class Car {

    private int speed;
    private int distance;

    public Car() {
        this(0, 0);
    }

    public Car(int speed, int distance) {
        this.speed = speed;
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move() {
        if (this.speed >= 4) {
            this.distance++;
        }
    }
}
