package step3;

import java.util.Random;

public class RacingCar {
    private static final int ADVANCE_CONDITION = 4;

    private RamdomCondition ramdomCondition;

    private int distance = 0;

    public RacingCar() {
        ramdomCondition = new RamdomCondition();
    }

    public boolean isMove() {
        return ramdomCondition.meet(ADVANCE_CONDITION);
    }

    public void move() {
        if (isMove()) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }


}
