package step5.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Test
    void 랜덤값으로_0과_9사이의_값이_생성된다() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        assertThat(randomNumberGenerator.generate())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
