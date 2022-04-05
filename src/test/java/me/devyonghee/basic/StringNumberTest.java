package me.devyonghee.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayName("문자열 숫자")
class StringNumberTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> StringNumber.from(""));
    }

    @Test
    @DisplayName("반드시 숫자 형태의 문자")
    void instance_notNumberFormat_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringNumber.from("abc"))
                .withMessageContaining("number format");
    }

    @ParameterizedTest(name = "[{index}] {0} 값을 0 또는 양수로 변환하면 {1}")
    @DisplayName("숫자 형태의 문자를 0 또는 양수로 변환")
    @CsvSource({"0,0", "10,10"})
    void zeroOrPositiveInt(String target, int expected) {
        //given
        StringNumber number = StringNumber.from(target);
        //when
        int integer = number.zeroOrPositiveInt();
        //then
        assertThat(integer).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}] {0} 값을 0 또는 양수로 변환하면 0")
    @DisplayName("빈 값을 정수로 변환하면 0")
    @NullAndEmptySource
    void zeroOrPositiveInt_empty_zero(String target) {
        //given
        StringNumber number = StringNumber.from(target);
        //when
        int integer = number.zeroOrPositiveInt();
        //then
        assertThat(integer).isZero();
    }

    @Test
    @DisplayName("음수를 0 또는 양수로 변환하면 illegalStateException")
    void zeroOrPositiveInt_negative_thrownIllegalStateException() {
        //given
        StringNumber minusOne = StringNumber.from("-1");
        //when, then
        assertThatIllegalStateException()
                .isThrownBy(minusOne::zeroOrPositiveInt)
                .withMessageContaining("can not parse");
    }
}
