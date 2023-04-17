package step3;

public class Engine {

    private static final int MINIMUM_CONDITION_FOR_START = 4;

    private final NumberGenerator numberGenerator;

    public Engine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean canStart() {
        int condition = numberGenerator.generateNumber();
        return condition >= MINIMUM_CONDITION_FOR_START;
    }
}
