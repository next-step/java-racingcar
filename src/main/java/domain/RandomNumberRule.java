package domain;

import util.RandomNumberGenerator;

public class RandomNumberRule implements Rule {
    private int startNumber;
    private int endNumber;
    private int conditionNumber;
    private RandomNumberGenerator randomNumberGenerator;

    public RandomNumberRule(int startNumber, int endNumber, int conditionNumber) {
        this(startNumber, endNumber, conditionNumber, new RandomNumberGenerator());
    }

    public RandomNumberRule(int startNumber, int endNumber, int conditionNumber, RandomNumberGenerator randomNumberGenerator) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.conditionNumber = conditionNumber;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public boolean canPass() {
        return randomNumberGenerator.nextInt(startNumber, endNumber) > conditionNumber;
    }
}
