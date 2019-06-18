package edu.nextstep.racing.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 20:26
 */
class NumberUtilsTest {

    @Test
    void 두개의_파라미터중_큰값_반환() {
        assertThat(NumberUtils.getMax(10,20)).isEqualTo(20);
    }

    @Test
    void 램던한_숫자를_반환() {
        assertThat(NumberUtils.getRandomNumber()).isBetween(0,9);
    }
}