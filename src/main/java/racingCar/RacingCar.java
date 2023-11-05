package racingCar;

import java.util.Random;

public class RacingCar {

    static final private int PIVOT_NUMBER_TO_FORWARD = 4;
    static final private int CLOSED_END_NUMBER_TO_GET_RANDOM_NUMBER_FROM_ZERO = 10;

    void racing(){

    }

    private boolean isSatisfiedForward(){
        return new Random().nextInt(CLOSED_END_NUMBER_TO_GET_RANDOM_NUMBER_FROM_ZERO) >= PIVOT_NUMBER_TO_FORWARD;
    }

}
