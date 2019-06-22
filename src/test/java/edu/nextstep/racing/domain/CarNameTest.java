package edu.nextstep.racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 14:25
 */
public class CarNameTest {

    @Test
    void 자동차이름_생성시_예외상황() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
           CarName name = new CarName("");
        });
    }

    @Test
    void 자동차이름_가져오기() {
        CarName name = new CarName("TEST");
        assertThat(name.getName()).isEqualTo("TEST");
    }
}
