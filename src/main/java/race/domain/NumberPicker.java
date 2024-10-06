package race.domain;

import java.util.Random;

public class NumberPicker {
    private Random random;

    public NumberPicker() {
        this.random = new Random();
    }

    public NumberPicker(Random random) {
        this.random = random;
    }

    public int generateRandomNumber(int limit) {
        return this.random.nextInt(limit);
    }
}
