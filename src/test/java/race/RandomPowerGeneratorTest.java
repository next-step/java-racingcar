package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomPowerGeneratorTest {
    @Test
    void 파워의_범위는_0부터_9까지_이다() {
        RandomPowerGenerator randomPowerGenerator = new RandomPowerGenerator();
        int power = randomPowerGenerator.generate();
        assertThat(power).isGreaterThanOrEqualTo(0);
        assertThat(power).isLessThanOrEqualTo(9);
    }
}
