package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @DisplayName("자동차 대수만큼 자동차가 만들어진다. (3 → 3대)")
    @Test
    public void test_1() {
        assertThat(new RacingGame(3, 0).getCarCount()).isEqualTo(3);
    }

    @DisplayName("자동차 대수가 0이거나 음수이면 RuntimeException (0, -1)")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void test_2(int carCount) {
        assertThatThrownBy(() -> new RacingGame(carCount, 1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 대수");
    }

    @DisplayName("시도 횟수가 음수이면 RuntimeException (-1)")
    @Test
    void test_3() {
        assertThatThrownBy(() -> new RacingGame(3, -1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("시도 횟수");
    }

}
