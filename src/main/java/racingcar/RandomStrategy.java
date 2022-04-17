package racingcar;

import java.util.Random;

public class RandomStrategy implements RollStrategy{
    public static int getRandom() {
        return new Random().nextInt(10);
    }
    public RolledResult roll(Car car) {
        int n = getRandom();
        if (n < 4) {
            return new RolledResult(false, car);
        }
        car.move();
        return new RolledResult(true, car);
    }

}
