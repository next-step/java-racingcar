package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("race 메서드에 0 혹은 음의 정수의 자동차 대수를 전달하면 IllegalArgumentException을 던진다.")
    void race_NegativeOrZeroCarCount_IllegalArgumentException(final int negativeOrZeroCarCount) {
        assertThatThrownBy(() -> Racing.race(negativeOrZeroCarCount, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 대수는 자연수만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("race 메서드에 0 혹은 음의 정수의 레이싱 시도 횟수를 전달하면 IllegalArgumentException을 던진다.")
    void race_NegativeOrZeroPlayingCount_IllegalArgumentException(final int negativeOrZeroPlayingCount) {
        assertThatThrownBy(() -> Racing.race(1, negativeOrZeroPlayingCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("레이싱 시도 횟수는 자연수만 가능합니다.");
    }
}
