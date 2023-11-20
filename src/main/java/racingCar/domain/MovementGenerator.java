package racingCar.domain;

public class MovementGenerator {
    public static final int MIN_MOVABLE_NUMBER = 4;
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
        return numberGenerator.generate() >= MIN_MOVABLE_NUMBER;
    }
}
