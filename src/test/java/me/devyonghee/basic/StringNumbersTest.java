package me.devyonghee.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 숫자")
class StringNumbersTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> StringNumbers.from(new String[]{"1", "2"}));
    }

    @Test
    @DisplayName("빈 객체화")
    void instance_empty() {
        assertThatNoException().isThrownBy(StringNumbers::empty);
    }

    @Test
    @DisplayName("양수들의 합")
    void positiveSum() {
        //given
        StringNumbers oneTwoNumbers = StringNumbers.from(new String[]{"1", "2"});
        //when
        int sum = oneTwoNumbers.positiveSum();
        //then
        assertThat(sum).isEqualTo(3);
    }

    @Test
    @DisplayName("비어있는 숫자들의 합은 0")
    void positiveSum_empty_zero() {
        //given
        StringNumbers empty = StringNumbers.empty();
        //when
        int sum = empty.positiveSum();
        //then
        assertThat(sum).isZero();
    }
}
