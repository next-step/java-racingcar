package race;

import java.util.Random;

public class CarRandomNumber implements RandomNumber {

    private int randomRange;

    private final static Random random = new Random();

    public CarRandomNumber(int randomRange) {
        this.randomRange = randomRange;
    }

    @Override
    public int randomNumber() {
        return random.nextInt(randomRange);
    }
}
