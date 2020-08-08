package step3.logic;

import java.util.Random;

public class CarMovement {

    static final private int CAR_GOING_DECISION_POINT = 4;

    private static int generateRandomCount() {
        Random randomGenerator = new Random();

        return randomGenerator.nextInt(10);
    }

    static public boolean isCarGoingForward() {

        return (CAR_GOING_DECISION_POINT <= generateRandomCount());
    }
}
