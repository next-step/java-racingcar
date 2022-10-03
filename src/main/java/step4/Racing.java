package step4;

import java.util.Random;

public class Racing {

    private static final int BETWEEN_ZERO_AND_NINE = 10;
    private static final int CONDITION = 4;
    private static Random random = new Random();

    public void racing (Car[] cars, int times) {
        for (int i = 0 ; i < times ; i++) {
            racingRound(cars);
        }
    }
    public void racingRound(Car[] cars) {
        for (int i = 0; i < cars.length ; i++) {
            moveOrStop(cars[i]);
        }

    }

    private void moveOrStop(Car car) {
        if (isSatisfiedConditionForMove(getRandomNum())) {
            car.move();
        }
    }

    public int getRandomNum() {
       return random.nextInt(BETWEEN_ZERO_AND_NINE);
    }

    public boolean isSatisfiedConditionForMove(int randomNumber) {
        return randomNumber >= CONDITION;
    }
}
