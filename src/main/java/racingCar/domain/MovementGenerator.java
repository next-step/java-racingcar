package racingCar.domain;

public class MovementGenerator {
    private final NumberGenerator numberGenerator;

    public MovementGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean generate() {
        if (isMovable(numberGenerator)) {
            return true;
        }
        return false;
    }

    private static boolean isMovable(NumberGenerator numberGenerator) {
        return numberGenerator.generate() >= 4;
    }
}
