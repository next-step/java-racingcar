package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomGenerator;

import static org.assertj.core.api.Assertions.*;
public class RandomGeneratorTest {

    private RandomGenerator randomGenerator = null;
    @BeforeEach
    public void beforeEach() {
        randomGenerator = new RandomGenerator();
    }

    @Test
    public void generatorTest() {
        assertThat(randomGenerator.getValue()).isBetween(0, 9);
    }
}
