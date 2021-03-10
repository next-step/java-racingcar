package racingcar.util;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilTest {

    @RepeatedTest(5)
    void getRandomIntBetweenZeroToNine() {
        int random = RandomUtil.getRandomIntBetweenZeroToNine();
        assertThat(random).isBetween(0, 9);
    }
}
