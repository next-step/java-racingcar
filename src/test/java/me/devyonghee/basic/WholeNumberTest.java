package me.devyonghee.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("범자연수")
class WholeNumberTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> WholeNumber.from("0"));
    }

    @Test
    @DisplayName("반드시 숫자 형태의 문자")
    void instance_notNumberFormat_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> WholeNumber.from("abc"));
    }

    @Test
    @DisplayName("반드시 0 또는 양수의 값")
    void instance_negative_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> WholeNumber.from("-1"));
    }

    @Test
    @DisplayName("두 숫자의 합")
    void add() {
        //given
        WholeNumber one = WholeNumber.from("1");
        WholeNumber two = WholeNumber.from("2");
        //when, then
        assertThat(one.add(two)).isEqualTo(WholeNumber.from("3"));
    }
}
