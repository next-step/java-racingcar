package racing.infra;

import java.security.SecureRandom;

public class RandomNumberGenerator {
    private SecureRandom secureRandom = new SecureRandom();

    public RandomNumber generate() {
        return RandomNumber.of(secureRandom.nextInt(RandomNumber.END_NUMBER) + RandomNumber.START_NUMBER);
    }
}
