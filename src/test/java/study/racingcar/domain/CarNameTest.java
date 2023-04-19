package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @DisplayName("자동차 이름 길이가 5이상일 경우 예외 발생")
    @Test
    void throw_exception_when_name_length_is_six() {
        // given
        String carName = "abcdef";

        // when, then
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("자동차 이름 길이가 5일 경우 예외 발생하지 않음")
    @Test
    void do_not_throw_exception_when_name_length_is_five() {
        // given
        String carName = "abcde";

        // when, then
        assertThatNoException().isThrownBy(() -> new CarName(carName));
    }

    @DisplayName("자동차 이름이 5이하일 경우 예외 발생하지 않음")
    @Test
    void do_not_throw_exception_when_name_length_is_four() {
        // given
        String carName = "abcd";

        // when, then
        assertThatNoException().isThrownBy(() -> new CarName(carName));
    }

    @DisplayName("자동차 이름 길이 측정시 공백 제거 하는지 테스트")
    @Test
    void when_name_contains_blank() {
        // given
        String carName = "    abcde   ";

        // when, then
        assertThatNoException().isThrownBy(() -> new CarName(carName));
    }

    @DisplayName("자동차 이름 길이가 주어지지 않은 경우 예외 발생")
    @Test
    void throw_exception_when_name_length_is_zero() {
        // given
        String carName = "     ";

        // when, then
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}