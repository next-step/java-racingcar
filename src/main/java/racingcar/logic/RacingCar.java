package racingcar.logic;

import java.util.Random;

public class RacingCar {
    private static Random RANDOM = new Random();
    private static final int INITIAL_POSITION = 0;
    static final int RACE_DECISION_NUMBER = 4;

    private final int carNo;
    private int position;

    private RacingCar(int carNo) {
        this.carNo = carNo;
        this.position = INITIAL_POSITION;
    }

    public static RacingCar createWithCarNo(int carNo) {
        return new RacingCar(carNo);
    }

    public void race() {
        int randomNumber = getRandomNumber();
        race(randomNumber);
    }

    public void race(int randomNumber) {
        if (randomNumber >= RACE_DECISION_NUMBER) {
            this.position++;
        }
    }

    private int getRandomNumber() {
        return RANDOM.nextInt(10);
    }

    public int getCarNo() {
        return this.carNo;
    }

    public int getPosition() {
        return this.position;
    }
}
