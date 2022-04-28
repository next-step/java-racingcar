package racingcar;

public class Car {

    private static final int MINIMUM_MOVABLE_SPEED = 4;

    private int distance;

    public Car() {
        this(0);
    }

    public Car(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public void move(int speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("속도는 음수값을 입력할 수 없습니다.");
        }

        if (speed >= MINIMUM_MOVABLE_SPEED) {
            this.distance++;
        }
    }
}
