package racingcar.domain;

import racingcar.random.RandomNumberGenerator;

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

    public void move(RandomNumberGenerator generator) {
        RandomNumber randomNumber = generator.generate();

        if (shouldMoveForward(randomNumber)) {
            this.distance.increase();
        }
    }

    private boolean shouldMoveForward(RandomNumber randomNumber) {
        return randomNumber.isGreaterThanOrEqual(FORWARD_THRESHOLD);
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
