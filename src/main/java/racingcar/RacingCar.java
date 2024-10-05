package racingcar;

import java.util.Random;

public class RacingCar {
    static Random RANDOM = new Random();
    static final int INITIAL_POSITION = 0;

    private final int carNo;
    private int position;

    private RacingCar(int carNo) {
        this.carNo = carNo;
        this.position = INITIAL_POSITION;
    }

    public void race() {
        int randomDecisionMaker = RANDOM.nextInt(10);
        if (randomDecisionMaker >= 4) {
            this.position++;
        }
    }

    public int getCarNo() {
        return this.carNo;
    }

    public int getPosition() {
        return this.position;
    }

    public static RacingCar createWithCarNo(int carNo) {
        return new RacingCar(carNo);
    }
}
