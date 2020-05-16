package racinggame.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    @DisplayName("자동차 이름과 이동 전략이 없으면 자동차를 생성하지 못한다.")
    @Test
    void canNotCreateRacingCarIfNameAndStrategyIsNull() {
        assertThatThrownBy(() -> RacingCar.newInstance(null, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 없으면 자동차를 생성하지 못한다.")
    @Test
    void canNotCreateRacingCarIfNameIsNull() {
        assertThatThrownBy(() -> RacingCar.newInstance(null, () -> true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 없으면 자동차를 생성하지 못한다.")
    @Test
    void canNotCreateRacingCarIfStrategyIsNull() {
        assertThatThrownBy(() -> RacingCar.newInstance("붕붕이", null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이동 전략이 있으면 자동차를 생성할 수 있다.")
    @Test
    void canCreateRacingCarIfStrategyIsNotNull() {
        assertThat(RacingCar.newInstance("붕붕이", () -> true)).isNotNull();
    }

    @DisplayName("자동차는 이름을 얻을 수 있다..")
    @ParameterizedTest
    @ValueSource(strings = { "붕붕이", "붕붕카", "싱싱카" })
    void canGetNameByRacingCar(String name) {
        RacingCar racingCar = RacingCar.newInstance(name, () -> true);
        racingCar.move();
        assertThat(racingCar.getName()).isEqualTo(name);
    }

    @DisplayName("자동차는 이동 전략으로 이동할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = { "true", "false" })
    void canMoveRacingCarByMovableStrategy(boolean isMovable) {
        RacingCar racingCar = RacingCar.newInstance("붕붕이", () -> isMovable);
        racingCar.move();
        assertThat(racingCar.getPosition()).isEqualTo(isMovable ? 1 : 0);
    }
}
