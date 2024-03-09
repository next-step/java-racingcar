package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @Test
    @DisplayName("자연수의 라운드는 정상 생성된다")
    void success_for_positive_round() {
        assertThatNoException()
            .isThrownBy(() -> new Round(1));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, -1 })
    @DisplayName("자연수가 아닌 라운드를 생성하려하면 예외가 발생한다")
    void success_for_positive_round(int input) {
        assertThatThrownBy(() -> new Round(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
