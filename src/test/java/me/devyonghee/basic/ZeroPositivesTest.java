package me.devyonghee.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("0 또는 양수들의 컬렉션")
class ZeroPositivesTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> ZeroPositives.from(Collections.singleton("1")));
    }

    @Test
    @DisplayName("숫자들의 합")
    void sum() {
        //given
        ZeroPositives oneTwoNumbers = ZeroPositives.from(Arrays.asList("1", "2"));
        //when, then
        assertThat(oneTwoNumbers.sum()).isEqualTo(ZeroPositive.from("3"));
    }

    @Test
    @DisplayName("숫자들이 비어있으면 합은 0")
    void sum_empty_zero() {
        //given
        ZeroPositives empty = ZeroPositives.from(Collections.emptyList());
        //when, then
        assertThat(empty.sum()).isEqualTo(ZeroPositive.ZERO);
    }
}
