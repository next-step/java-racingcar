package racing;

public class RandomNumberProvider implements NumberProvider{
    @Override
    public int getNumber() {
        return RandomNumberGenerator.getRandomInt();
    }
}
