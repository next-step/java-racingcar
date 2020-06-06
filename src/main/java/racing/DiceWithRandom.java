package racing;

import java.util.Random;

public class DiceWithRandom implements Dice {

    private final int MAX_NUMBER = 10;
    private Random random = new Random();

    @Override
    public int makeNumber() {

        return random.nextInt(MAX_NUMBER);
    }
}
