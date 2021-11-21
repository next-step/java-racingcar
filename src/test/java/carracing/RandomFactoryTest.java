package carracing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomFactoryTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10, 999})
    void generateRandomWithBound(int bound) {
        RandomFactory randomFactory = new RandomFactory();
        for (int i = 0; i < 1000000; i++) {
            int random = randomFactory.generate(bound);
            assertThat(random).isGreaterThanOrEqualTo(0);
            assertThat(random).isLessThan(bound);
        }
    }
}
