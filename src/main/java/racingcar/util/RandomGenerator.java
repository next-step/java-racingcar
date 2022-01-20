package racingcar.util;

import java.util.Random;

public class RandomGenerator {
    public int generateRandomNumber(){
        Random random= new Random();
        return random.nextInt(9);
    }
}
