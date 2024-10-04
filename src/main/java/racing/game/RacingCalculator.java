package racing.game;

public class RacingCalculator {

    private final RandomGenerator randomGenerator;

    public RacingCalculator() {
        this.randomGenerator = new RandomGenerator();
    }

    public RacingCalculator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public int getRandomNumber() {
        return randomGenerator.getRandomNumber();
    }

}
