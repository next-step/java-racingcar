package step4.model;

import java.util.Random;

public class RandomFactory {

    static final Random random = new Random();

    static int getRandomInt(int bound){
        return random.nextInt(bound);
    }
}
