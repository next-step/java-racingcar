package racing;

import java.util.Random;

public class ZeroToTenDice implements Dice {
    private final Random random;

    public ZeroToTenDice() {
        this.random = new Random();
    }

    @Override
    public int roll() {
        return random.nextInt(10);
    }
}
