package racing.model.strategy;

public class ManualNumberGenerator implements NumberGeneratorStrategy{
    @Override
    public int generateNumber(int number) {
        return number;
    }
}
