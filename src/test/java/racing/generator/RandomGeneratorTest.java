package racing.generator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {
    @Test
    void generateTest() {
        //given
        RandomGenerator randomGenerator = new RandomGenerator();

        //when
        int randomValue = randomGenerator.generate();

        //then
        assertThat(randomValue).isGreaterThanOrEqualTo(0);
        assertThat(randomValue).isLessThanOrEqualTo(9);
    }
}
