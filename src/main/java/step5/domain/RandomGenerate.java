package step5.domain;

import java.util.Random;

public class RandomGenerate implements GenerateNumber {

    private final static int RANDOM_NUM = 10;
    Random random = new Random();
    @Override
    public int generateRandom() {
        return random.nextInt(RANDOM_NUM);
    }

    public int moreThenFour() {
        return 4;
    }

    public int lessThenFour() {
        return 3;
    }
}
