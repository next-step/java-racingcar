package racingcar.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilsTest {
    @Test
    public void 영부터_구_사이() {
        // given
        // when
        final int number = RandomUtils.nextInt(0, 9);

        // then
        for (int i = 0; i < 100; i++) {
            assertThat(number).isBetween(0, 9);
        }
    }
}