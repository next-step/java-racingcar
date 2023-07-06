package racingcar.number_generator;

public class SpecificNumberGenerator implements NumberGenerator {

    private final int specificNumber;

    public SpecificNumberGenerator(int specificNumber) {
        this.specificNumber = specificNumber;
    }

    @Override
    public int generate() {
        return specificNumber;
    }
}
