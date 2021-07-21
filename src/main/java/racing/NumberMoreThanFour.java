package racing;

public class NumberMoreThanFour implements ForwardStrategy {
    @Override
    public boolean condition() {
        return !(RandomNumberGenerator.generate() >= 4);
    }
}
