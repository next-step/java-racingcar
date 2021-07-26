package racingcar.util;

import org.junit.jupiter.api.RepeatedTest;
import racingcar.util.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @RepeatedTest(100)
    void generateRandomNumber() {
        int randomNumber = RandomNumberGenerator.generate();
        assertThat(randomNumber).isLessThan(10);
        assertThat(randomNumber).isGreaterThanOrEqualTo(0);
    }
}
