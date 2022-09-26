package step3.racingcar.domain;

public class Car {
    public static final int MOVING_THRESHOLD = 4;
    private int randomValue;

    private Car() {
    }

    public Car(int randomValue) {
        if(isMoving(randomValue)) {

        }
    }
    
    public int run(int randomValue) {
        if(isMoving(randomValue)) {
            return 0;
        }
    }

    private boolean isMoving(int randomValue) {
        return randomValue >= MOVING_THRESHOLD;
    }
}
