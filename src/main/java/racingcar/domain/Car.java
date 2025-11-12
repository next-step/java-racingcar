package racingcar.domain;

public class Car {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int FORWARD_THRESHOLD = 4;

    private final CarName name;
    private final CarDistance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new CarDistance();
    }

    public void move(int randomValue) {
        validateRandomValue(randomValue);

        if (shouldMoveForward(randomValue)) {
            this.distance.increase();
        }
    }

    private void validateRandomValue(int randomValue) {
        if (isOutOfRange(randomValue)) {
            throw new IllegalArgumentException("랜덤 값은 0 이상 9 이하이어야 합니다.");
        }
    }

    private boolean isOutOfRange(int randomValue) {
        return randomValue < MIN_RANDOM_VALUE || randomValue > MAX_RANDOM_VALUE;
    }

    private boolean shouldMoveForward(int randomValue) {
        return randomValue >= FORWARD_THRESHOLD;
    }

    public CarSnapshot toSnapshot() {
        return new CarSnapshot(name.value(), distance.getValue());
    }

    public String getName() {
        return this.name.value();
    }

    public int getDistance() {
        return this.distance.getValue();
    }
}
