package racing.strategy;

import java.util.List;
import java.util.Random;

public class RacingMoveStategy implements MoveStrategy {

    private static Integer MINIMUM_NUMBER = 3;
    private static Integer MAX_NUMBER = 10;
    @Override
    public int move() {
        int randomVal = getRandomValue();
        return isGreaterThanMinimum(randomVal)?randomVal:0;
    }

    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER);
    }

    public boolean isGreaterThanMinimum(int randomNum) {
        return randomNum > MINIMUM_NUMBER;
    }

}
