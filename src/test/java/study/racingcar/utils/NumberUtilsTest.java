package study.racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberUtilsTest {

    @DisplayName("입력값이 0일때")
    @Test
    void when_input_is_zero() {
        // given
        int num = 0;

        // when
        boolean actualResult = NumberUtils.isNotPositive(num);

        // then
        assertThat(actualResult).isTrue();
    }

    @DisplayName("입력값이 음수일때")
    @Test
    void when_input_is_negative() {
        int num = -1;

        // when
        boolean actualResult = NumberUtils.isNotPositive(num);

        // then
        assertThat(actualResult).isTrue();
    }

    @DisplayName("입력값이 양수일때")
    @Test
    void when_input_is_positive() {
        int num = 1;

        // when
        boolean actualResult = NumberUtils.isNotPositive(num);

        // then
        assertThat(actualResult).isFalse();
    }
}