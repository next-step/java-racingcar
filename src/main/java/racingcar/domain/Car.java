package racingcar.domain;

import racingcar.random.RandomNumberGenerator;

public class Car {
    private final CarName name;
    private CarDistance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new CarDistance();
    }

    public void move(RandomNumberGenerator generator) {
        RandomNumber randomNumber = generator.generate();

        if (randomNumber.canMoveForward()) {
            this.distance = distance.increase();
        }
    }

    public CarSnapshot toSnapshot() {
        return new CarSnapshot(name, distance);
    }
}
