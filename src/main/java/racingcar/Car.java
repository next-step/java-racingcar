package racingcar;

public class Car {

    private static final int MINIMUM_MOVABLE_SPEED = 4;
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
        if (speed < 0) {
            throw new IllegalArgumentException("속도는 음수값을 입력할 수 없습니다.");
        }
        this.speed = speed;
    }

    public void move() {
        if (this.speed >= MINIMUM_MOVABLE_SPEED) {
            this.distance++;
        }
    }
}
