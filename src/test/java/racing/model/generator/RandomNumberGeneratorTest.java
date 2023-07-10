package racing.model.generator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @Test
    void generateTest() {
        //given
        RandomNumberGenerator randomGenerator = RandomNumberGenerator.getInstance();

        //when
        int randomValue = randomGenerator.generate();

        //then
        assertThat(randomValue).isGreaterThanOrEqualTo(0);
        assertThat(randomValue).isLessThanOrEqualTo(9);
    }
}
