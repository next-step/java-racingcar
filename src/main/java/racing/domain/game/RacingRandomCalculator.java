package racing.domain.game;

public class RacingRandomCalculator implements Calculator {

    private final RandomGenerator randomGenerator;

    public RacingRandomCalculator() {
        this.randomGenerator = new RandomGenerator();
    }

    public RacingRandomCalculator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public int getRandomNumber() {
        return randomGenerator.getRandomNumber();
    }


}
