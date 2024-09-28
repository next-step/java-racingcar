package race;

import java.util.Random;

public class CarRandomNumber implements RandomNumber {

    private int randomRange;

    private final static Random RANDOM = new Random();

    public CarRandomNumber(int randomRange) {
        this.randomRange = randomRange;
    }

    @Override
    public int randomNumber() {
        return RANDOM.nextInt(randomRange);
    }
}
