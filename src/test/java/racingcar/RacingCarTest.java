package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @DisplayName("4이상 9이하이면 다음 위치는 현재 위치보다 1 많다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void nextPosition_plusOne(Integer randomNumber) {
        RacingCar racingCar = RacingCar.positionOf(0);

        assertThat(racingCar.nextPosition(randomNumber)).isEqualTo(1);
    }

    @DisplayName("0이상 3이하이면 다음 위치는 현재 위치와 같다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void nextPosition_same(Integer randomNumber) {
        RacingCar racingCar = RacingCar.positionOf(0);

        assertThat(racingCar.nextPosition(randomNumber)).isEqualTo(0);
    }
}