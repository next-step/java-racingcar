package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    @DisplayName("자동차 이동 전략이 없으면 자동차를 생성하지 못한다.")
    @Test
    void canNotCreateRacingCarIfStrategyIsNull() {
        assertThatThrownBy(() -> RacingCar.newInstance(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이동 전략이 있으면 자동차를 생성할 수 있다.")
    @Test
    void canCreateRacingCarIfStrategyIsNotNull() {
        assertThat(RacingCar.newInstance(() -> true)).isNotNull();
    }

    @DisplayName("자동차는 이동 전략으로 이동할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = { "true", "false" })
    void canMoveRacingCarByMovableStrategy(boolean isMovable) {
        RacingCar racingCar = RacingCar.newInstance(() -> isMovable);
        racingCar.move();
        assertThat(racingCar.currentPosition()).isEqualTo(isMovable ? 1 : 0);
    }
}
