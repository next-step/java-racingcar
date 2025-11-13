package racingcar.domain;

import racingcar.policy.MovePolicy;
import racingcar.random.RandomNumberGenerator;

public class Car {
    private final CarName name;
    private CarDistance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new CarDistance();
    }

    public void move(RandomNumberGenerator generator, MovePolicy movePolicy) {
        RandomNumber randomNumber = generator.generate();

        if (movePolicy.canMove(randomNumber)) {
            this.distance = distance.increase();
        }
    }

    public CarSnapshot toSnapshot() {
        return new CarSnapshot(name, distance);
    }
}
