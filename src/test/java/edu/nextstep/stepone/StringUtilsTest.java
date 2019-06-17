package edu.nextstep.stepone;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-17 15:56
 */
class StringUtilsTest {

    @Test
    void 문자에서_숫자로_변환() {
        assertThat(StringUtils.convertInt("10")).isEqualTo(10);
    }

    @Test
    void 문자에서_숫자로_변환예외상황() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringUtils.convertInt("+");
        });
    }
}