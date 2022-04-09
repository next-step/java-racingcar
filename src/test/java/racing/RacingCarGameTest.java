package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingCarGameTest {

    @DisplayName("자동차 수를 1대 보다 작게 입력하면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-5, 0})
    void createGameThrowException(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new RacingCarGame(input));
    }

    @DisplayName("이동횟수를 1 보다 작게 입력하면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-5, 0})
    void runThrowException(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new RacingCarGame(3).run(input));
    }
}