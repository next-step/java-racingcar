package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DrivingDistanceTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    @DisplayName("양수나 0이라면 성공적으로 생성된다")
    void success_for_0_or_positive(int input) {
        assertThatNoException()
            .isThrownBy(() -> DrivingDistance.of(input));
    }

    @Test
    @DisplayName("음수로 생성하려하면 예외가 발생한다")
    void fail_for_negative() {
        assertThatThrownBy(() -> DrivingDistance.of(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
