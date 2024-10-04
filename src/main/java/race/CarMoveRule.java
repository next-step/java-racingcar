package race;

public class CarMoveRule implements ICarMoveRule {
    private static final int END_OF_RANDOM = 10;
    private static final int STANDARD = 4;

    private final IRandomValueGenerator randomValueGenerator;

    private CarMoveRule(IRandomValueGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }

    public boolean check() {
        return this.randomValueGenerator.generateFromZeroTo(END_OF_RANDOM) >= STANDARD;
    }

    public static CarMoveRule with(IRandomValueGenerator randomValueGenerator) {
        return new CarMoveRule(randomValueGenerator);
    }
}
