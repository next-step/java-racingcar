package step3;

import java.util.Random;

public class Car {

    private static final Random random = new Random();

    private int miles = 0;

    private boolean canAdvance() {
        return random.nextInt(10) >= 4;
    }

    public boolean advance() {
        boolean res = canAdvance();
        if (res) {
            this.miles++;
        }
        return res;
    }

    public int getMiles() {
        return this.miles;
    }

}
