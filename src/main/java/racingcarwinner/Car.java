package racingcarwinner;

import racingcar.RandomGenerator;

public class Car {

    private final int ENABLE_MOVE_NUMBER = 4;
    private int travelDistance;
    private RandomGenerator randomGenerator = new RandomGenerator();

    public void move(){
        this.travelDistance++;
    }

    public boolean isOrAboveEnableNumber(int randomNumber){
        return randomNumber >= ENABLE_MOVE_NUMBER;
    }

    public int getTravelDistance(){
        return this.travelDistance;
    }
}
