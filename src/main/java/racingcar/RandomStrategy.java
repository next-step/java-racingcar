package racingcar;

import java.util.Random;

public class RandomStrategy implements MovableStrategy{
    @Override
    public int move() {
        return new Random().nextInt(10);
    }
}
