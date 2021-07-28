package racingcar;

import java.util.Random;

public class RandomRaceStrategy implements RaceStrategy {
    @Override
    public void move(Car car) {
        if ((new Random()).nextInt(10) >= 4) {
            car.move();
        }
    }
}
