package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private final RacingCar racingCar = new RacingCar();

    @DisplayName("자동차의 출발 위치는 0")
    @Test
    void startingPositionOfTheCarIsZero() {
        assertThat(racingCar.getPosition())
                .isEqualTo(0);
    }

    @DisplayName("Random 4 이상 이면 전진 또는 Random 4 미만 이면 정지")
    @ParameterizedTest
    @ValueSource(ints = {4, 7, 8, 3, 2})
    void random4OrHigherForward(int input) {
        racingCar.move(input);
        assertThat(racingCar.getPosition() >= 4 && racingCar.getPosition() < 4);
    }


}
