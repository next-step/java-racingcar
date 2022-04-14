package racingcar.racing;

import java.util.Random;

public class NumberGenerator {

    private static final Random random = new Random();

    private int value;
    public NumberGenerator(int value) {
        this.value = value;
    }

    public int generateNumber() {
        return random.nextInt(value);
    }
}
