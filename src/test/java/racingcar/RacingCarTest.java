package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.helper.Fixture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("레이싱 카 게임 테스트")
class RacingCarTest {

    @DisplayName("레이싱 카 게임은 차의 숫자와 MoveStrategy 를 가지고 초기화 한다.")
    @Test
    void init() {
        assertThat(RacingCar.init(10, Fixture.alwaysMoveStrategy())).isNotNull();
    }

    @DisplayName("레이싱 카 게임은 차의 숫자가 음수일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void numberOfCarsShouldBeOverZero(int numberOfCars) {
        assertThatThrownBy(() -> RacingCar.init(numberOfCars, Fixture.neverMoveStrategy())).isInstanceOf(IllegalArgumentException.class);
    }

}
