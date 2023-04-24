package racingcar.util;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomGeneratorTest {

    @Test
    void 주어진_두_인자를_포함한_범위의_랜덤값을_생성한다() {
        int min = 0;
        int max = 9;

        int res = RandomGenerator.generate(min, max);

        assertThat(res).isBetween(min, max);
    }
}
