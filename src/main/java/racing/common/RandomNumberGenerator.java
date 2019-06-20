package racing.common;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final static int INCREASED_NUMBER = 1;
    private final Random generator;
    private final int maxNumber;
    
    public RandomNumberGenerator(int maxNumber) {
        this.maxNumber = maxNumber;
        generator = new Random();
    }
    
    @Override
    public int getNumber() {
        return generator.nextInt(maxNumber + INCREASED_NUMBER);
    }
}
