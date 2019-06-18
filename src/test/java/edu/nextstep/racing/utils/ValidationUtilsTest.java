package edu.nextstep.racing.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 20:39
 */
class ValidationUtilsTest {

    @Test
    void 객체가_NULL인지_체크() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidationUtils.checkNull(null);
        });
    }

    @Test
    void 객체가_EMPTY인지_체크() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidationUtils.checkEmpty("");
        });
    }

    @Test
    void 좌측기준값과_보다_우측비교값이_큰값인지_체크() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidationUtils.checkMinValue(10,1);
        });
    }
}