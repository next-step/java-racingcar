package racingcar;

import java.util.Random;

public class RacingCar {
    private final int carNo;
    private int position;

    static Random random = new Random();
    static int INITIAL_POSITION = 0;

    private RacingCar(int carNo) {
        this.carNo = carNo;
        this.position = INITIAL_POSITION;
    }

    public void race() {
        int randomDecisionMaker = random.nextInt(10);
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
