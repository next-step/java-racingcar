package racing;

import java.util.Random;

public class RandomNumber {
    Random random = new Random();
    int boundNumber = 10;

    public int getRandomNumber() {
        return random.nextInt(boundNumber);
    }


}
