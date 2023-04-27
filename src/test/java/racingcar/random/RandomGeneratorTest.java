package racingcar.random;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomGeneratorTest {

    @Test
    void 최소값_이상의_랜덤값을_생성한다() {
        int min = 0;
        int max = 9;

        RandNum res = RandomGenerator.generate(min, max);

        assertThat(res.isGreaterThan(min)).isTrue();
    }
}
