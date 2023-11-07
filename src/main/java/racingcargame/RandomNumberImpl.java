package racingcargame;

import java.util.Random;

public class RandomNumberImpl implements RandomNumber {

    @Override
    public int getRandomNumber(int bound) {
        return new Random().nextInt(bound);
    }
}
