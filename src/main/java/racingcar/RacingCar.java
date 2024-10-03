package racingcar;

import java.util.Random;

public class RacingCar {
    private int carNo;
    private int position;

    static Random random = new Random();
    static int INITIAL_POSITION = 0;

    public RacingCar(int carNo) {
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
}
