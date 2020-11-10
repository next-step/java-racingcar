package study.racing;

import java.util.Random;

public class RandomMoveStrategy implements RacingMoveStrategy {
    private static final int MAX_RANDOM_INT = 10;
    private static final int THRESHOLD_TO_MOVE= 4;

    public int getRandomInt() {
        Random ran = new Random();
        return ran.nextInt(MAX_RANDOM_INT);
    }

    @Override
    public int getMovement() {
        int movement = 0;
        int randomInt = getRandomInt();
        if(randomInt >= THRESHOLD_TO_MOVE){
            movement++;
        }
        return movement;
    }
}
