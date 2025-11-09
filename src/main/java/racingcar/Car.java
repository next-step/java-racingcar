package racingcar;

public class Car {
    private static final int DEFAULT_DISTANCE = 0;

    private int distance;

    public Car() {
        this.distance = DEFAULT_DISTANCE;
    }

    public void move(int value) {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("랜덤 값은 0 이상 9 이하이어야 합니다.");
        }

        if (value >= 4) {
            this.distance += 1;
        }
    }

    public int getDistance() {
        return this.distance;
    }
}
