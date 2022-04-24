package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberOfRoundTest {

    @DisplayName("음수는 Exception이 발생한다.")
    @ValueSource(ints = { -1 })
    @ParameterizedTest
    void 음수_입력(int number) {
        assertThatThrownBy(() -> NumberOfRound.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수");
    }

    @DisplayName("값이 하나 감소한다.")
    void decrease() {
        final NumberOfRound beforeRound = NumberOfRound.of(3);

        final NumberOfRound decreaseRound = beforeRound.decrease();

        assertThat(decreaseRound).isEqualTo(NumberOfRound.of(2));
    }
}
