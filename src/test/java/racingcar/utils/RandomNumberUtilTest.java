package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberUtilTest {

    @Test
    void 랜덤숫자_뽑기() {
        int number = RandomNumberUtil.getRandomNumber(9);

        assertThat(number).isGreaterThan(-1);
        assertThat(number).isLessThan(10);
    }

}