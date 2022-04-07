package me.devyonghee.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("범자연수 일급 컬렉션")
class WholeNumbersTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> WholeNumbers.from(Collections.singleton("1")));
    }

    @Test
    @DisplayName("컬렉션은 필수")
    void instance_null_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> WholeNumbers.from(null));
    }

    @Test
    @DisplayName("숫자들의 합")
    void sum() {
        //given
        WholeNumbers oneTwoNumbers = WholeNumbers.from(Arrays.asList("1", "2"));
        //when, then
        assertThat(oneTwoNumbers.sum()).isEqualTo(WholeNumber.from("3"));
    }

    @Test
    @DisplayName("숫자들이 비어있으면 합은 0")
    void sum_empty_zero() {
        //given
        WholeNumbers empty = WholeNumbers.from(Collections.emptyList());
        //when, then
        assertThat(empty.sum()).isEqualTo(WholeNumber.ZERO);
    }
}
