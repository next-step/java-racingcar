package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.common.RandomNumberGenerator;

public class RandomNumberGeneratorTest {
    @Test
    void constructorTest() {
        final int MIN_NUMBER = 0;
        final int MAX_NUMBER = 9;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(MAX_NUMBER);
        Assertions.assertThat(randomNumberGenerator.getNumber()).isBetween(MIN_NUMBER, MAX_NUMBER);
    }
}
