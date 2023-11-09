package racingCar;

import java.util.Random;

public class RandomNumber {
    public static int getRandom(int value){
        Random random = new java.util.Random();
        return random.nextInt(value);
    }
}
