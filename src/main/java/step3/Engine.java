package step3;

public class Engine {

    private final NumberGenerator numberGenerator;

    public Engine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean isOk() {
        int condition = numberGenerator.generateNumber();
        return condition >= 4;
    }
}
