package racingcar.domain;

import racingcar.utils.RandomNumber;

public class Car {

    private int position;
    private static final int MOVING_CONDITION_MIN_VALUE = 4;

    public Car(){
        this.position = 0;
    }

    public void move() {
        if(isMovable()){
            this.position++;
        }
    }

    private boolean isMovable() {
        return generateRandomNumber() >= MOVING_CONDITION_MIN_VALUE;
    }

    protected int generateRandomNumber(){
        return RandomNumber.generate();
    }

    public int getPosition(){
        return this.position;
    }
}
