package racinggamewinner.random;

public class NumberGenerateStrategy implements NumberGenerator {
    private NumberGenerator numberGeneratorStrategy;

    public NumberGenerateStrategy(NumberGenerator numberGeneratorStrategy) {
        this.numberGeneratorStrategy = numberGeneratorStrategy;
    }

    @Override
    public int executeStrategy() {
        return numberGeneratorStrategy.executeStrategy();
    }

}
