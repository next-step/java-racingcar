package me.devyonghee.racingcar.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("검증")
class AssertTest {

    @Test
    @DisplayName("객체화 불가능")
    void instance_thrownAssertionError() {
        assertThatExceptionOfType(AssertionError.class)
                .isThrownBy(() -> ReflectionUtils.newInstance(Assert.class));
    }

    @Test
    @DisplayName("null 검증")
    void notNull() {
        //given
        String error = "error";
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> Assert.notNull(null, error))
                .withMessage(error);
    }
}
