package step3.strategy;


import java.util.Random;

public class RandomStrategy implements MoveStrategy {

    private static final Random random = new Random();
    private static final Integer bound = 9;

    @Override
    public int generate() {
        return random.nextInt(bound);
    }

}
