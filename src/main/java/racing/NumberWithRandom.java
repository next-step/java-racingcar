package racing;

import java.util.Random;

public class NumberWithRandom implements RandomStrategy {
    private int range;

    public NumberWithRandom(int number) {
        this.range = number;
    }

    @Override
    public int makeRandomNumber() {
        return new Random().nextInt(this.range);
    }
}
