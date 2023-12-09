package racingcar.util;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilsTest {
    @RepeatedTest(100)
    void getRandomIntTest() {
        assertThat(RandomUtils.getRandomInt(10)).isBetween(0, 9);
    }
}