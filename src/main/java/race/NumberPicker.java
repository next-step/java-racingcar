package race;

import java.util.Random;

public class NumberPicker {
    private Random random;

    public NumberPicker() {
        this.random = new Random();
    }

    public NumberPicker(Random random) {
        this.random = random;
    }

    public int generateRandomNumberUnderTen() {
        return this.random.nextInt(10);
    }
}
