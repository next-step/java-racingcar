package carracing.domain;

import java.util.Random;

public class RandomGenerator {

    public int makeRandomValue(){

        Random random = new Random();
        return random.nextInt(10);
    }

}
