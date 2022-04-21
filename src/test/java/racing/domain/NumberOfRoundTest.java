package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberOfRoundTest {

    @DisplayName("양수로 만들어진다.")
    @ValueSource(ints = { 1, 2, 10 })
    @ParameterizedTest
    void 양수_입력(int number) {
        final NumberOfRound numberOfRound = NumberOfRound.of(number);

        assertThat(numberOfRound.getNumber()).isEqualTo(number);
    }

    @DisplayName("0과 음수는 Exception이 발생한다.")
    @ValueSource(ints = { -1, 0 })
    @ParameterizedTest
    void 음수_입력(int number) {
        assertThatThrownBy(() -> NumberOfRound.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수");
    }
}
