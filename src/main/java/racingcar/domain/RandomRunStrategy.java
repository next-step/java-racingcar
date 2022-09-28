package racingcar.domain;


import java.util.Random;

public class RandomRunStrategy implements RunStrategy {

    private static final int RUNNABLE_BOUND = 4;
    private static final int MAX_VALUE = 10;
    private static final Random random = new Random();

    @Override
    public boolean runnable() {
        return getRandomNumber() >= RUNNABLE_BOUND;
    }

    private int getRandomNumber() {
        return random.nextInt(MAX_VALUE);
    }

}
