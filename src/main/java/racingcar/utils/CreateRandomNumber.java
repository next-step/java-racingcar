package racingcar.utils;

import java.util.Random;

public class CreateRandomNumber implements MovingStrategy{
    private static final int MAX = 10;
    private static final int MOVE_NUM = 4;
    private static Random random = new Random();

    public static int getRandomNumber(){
        return random.nextInt(MAX);
    }

    @Override
    public boolean isMoving() {
        return random.nextInt(MAX)>=MOVE_NUM;
    }
}
