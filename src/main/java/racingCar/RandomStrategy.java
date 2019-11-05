package racingCar;

import java.util.Random;

public class RandomStrategy implements Moveable {
    @Override
    public int move() {
        Random random = new Random();
        int result = random.nextInt(10);
        return result;
    }
}
