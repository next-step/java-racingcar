package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Test
    void 랜덤_값을_0이상_9이하의_값으로_반환한다() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        int value = randomNumberGenerator.generate();

        assertThat(value).isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
