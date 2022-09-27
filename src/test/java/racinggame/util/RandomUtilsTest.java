package racinggame.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilsTest {

    @Test
    void 랜덤_숫자가_0_9_사이로_생성된다() {
        for (int i = 0; i < 1000; i++) {
            int number = RandomUtils.randomNumber(10);
            assertThat(number).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
        }

    }

}