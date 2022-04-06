package me.devyonghee.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("0 또는 양수")
class ZeroPositiveTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> ZeroPositive.from("0"));
    }

    @Test
    @DisplayName("반드시 숫자 형태의 문자")
    void instance_notNumberFormat_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> ZeroPositive.from("abc"));
    }

    @Test
    @DisplayName("반드시 양수의 값")
    void instance_negative_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> ZeroPositive.from("-1"));
    }

    @Test
    @DisplayName("두 숫자의 합")
    void add() {
        //given
        ZeroPositive one = ZeroPositive.from("1");
        ZeroPositive two = ZeroPositive.from("2");
        //when, then
        assertThat(one.add(two)).isEqualTo(ZeroPositive.from("3"));
    }
}
