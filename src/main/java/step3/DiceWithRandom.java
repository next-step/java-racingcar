package step3;

import java.util.Random;

public class DiceWithRandom implements Dice{

    private final static int MAX_NUMBER = 10;
    Random random = new Random();

    @Override
    public int makeRandomNumber() {

        return random.nextInt(MAX_NUMBER);
    }
}
