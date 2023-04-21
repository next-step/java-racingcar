package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @DisplayName("자동차 이름 길이가 5이상일 경우 예외 발생")
    @Test
    void when_carNameOver5_Expect_ThrowsException() {
        // given
        String carName = "abcdef";

        // when, then
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("자동차 이름 길이가 5이하일 경우 예외 발생하지 않음")
    @ParameterizedTest
    @ValueSource(strings = {"abcde", "    abcde   ", "abcd", "a"})
    void when_carNameLessThanOrEqualTo5_Expect_NoException(String carName) {
        assertThatNoException().isThrownBy(() -> new CarName(carName));
    }

    @DisplayName("자동차 이름 길이가 주어지지 않은 경우 예외 발생")
    @Test
    void when_NoCarName_Expect_ThrowsException() {
        // given
        String carName = "     ";

        // when, then
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}