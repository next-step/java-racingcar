package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.RandomGenerator;

import static org.assertj.core.api.Assertions.*;
public class RandomGeneratorTest {

    @Test
    public void generatorTest() {
        assertThat(RandomGenerator.getValue()).isBetween(0, 9);
    }
}
