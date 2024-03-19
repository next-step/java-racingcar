package racingcar;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMove implements Movable {
    @Override
    public void moveCar(Car car) {
        car.moveForward(ThreadLocalRandom.current().nextInt(1, 10));
    }
}
