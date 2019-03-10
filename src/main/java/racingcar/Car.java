package racingcar;

import java.util.Random;

public class Car {
    //이동기능, 이동거리 기록
    private static final int RULE_COUNT = 10;
    private static final int RUNNABLE_RULE_COUNT = 3;


    private int movingDistance = 0;

    public int getMovingDistance() {
        return movingDistance;
    }

    public void moveCar() {
        movingDistance++;
    }

    public boolean canMove() {
        return new Random().nextInt(RULE_COUNT) > RUNNABLE_RULE_COUNT;
    }
}
