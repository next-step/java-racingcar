package racing.utils;

import java.util.Random;

public class RandomNumber {
    
    public int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
