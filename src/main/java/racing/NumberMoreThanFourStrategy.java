package racing;

public class NumberMoreThanFourStrategy implements ForwardStrategy {
    @Override
    public boolean condition() {
        return !(RandomNumberGenerator.generate() >= 4);
    }
}
