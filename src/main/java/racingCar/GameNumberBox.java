package racingCar;

import java.util.Random;

public class GameNumberBox implements NumberBox {
    @Override
    public int getRandomInt(int end) {
        return new Random().nextInt(end);
    }
}
