package racing;

import java.util.Random;

public class RandomNumberGenerator {
    private final static int INCREASED_NUMBER = 1;
    private Random generator;
    private int maxNumber;
    
    public int getMaxNumber() {
        return maxNumber;
    }
    
    public RandomNumberGenerator(int maxNumber) {
        this.maxNumber = maxNumber;
        generator = new Random();
    }
    
    public int getNumber() {
        return generator.nextInt(maxNumber + INCREASED_NUMBER);
    }
}
