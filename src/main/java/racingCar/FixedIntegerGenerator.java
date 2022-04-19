package racingCar;

public class FixedIntegerGenerator implements IntegerGeneratorStrategy {
    private final int number;

    FixedIntegerGenerator(int number) {
        this.number = number;
    }

    public int generate() {
        return this.number;
    }
}
