package step3.model;

import java.util.Random;

public class Car {
    private static final int INITIAL_COUNT = 0;
    private static final int MOVE_MIN_NUMBER = 4;
    private static final int RANDOM_MAX_NUMBER = 10;
    private static final Random random = new Random();

    private int moveCount;

    public Car() {
        this.moveCount = INITIAL_COUNT;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void moveOrStop(){
        move(getRandomValue());
    }

    public void move(int randomValue) {
        if(randomValue >= MOVE_MIN_NUMBER){
            moveCount++;
        }
    }

    private int getRandomValue(){
        return random.nextInt(RANDOM_MAX_NUMBER);
    }
}
