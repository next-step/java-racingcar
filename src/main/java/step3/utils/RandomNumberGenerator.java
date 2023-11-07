package step3.utils;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return RandomUtils.generateRandomNumber();
    }
}
