package racinggamewinner.random;

public class NumberGenerateStrategy {
    private NumberGenerator numberGeneratorStrategy;

    public NumberGenerateStrategy(NumberGenerator numberGeneratorStrategy) {
        this.numberGeneratorStrategy = numberGeneratorStrategy;
    }

    public int executeStrategy() {
        return numberGeneratorStrategy.generateNumber();
    }


}
