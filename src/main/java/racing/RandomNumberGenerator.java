package racing;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random RANDOM = new Random();
    public static int randomNumber(){
        return RANDOM.nextInt(10);
    }

}
