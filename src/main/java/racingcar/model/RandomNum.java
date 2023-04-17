package racingcar.model;

import java.util.Random;

public class RandomNum {

    public static final Random random = new Random();

    public static int getRandomNum(){
        return random.nextInt(10);
    }
}
