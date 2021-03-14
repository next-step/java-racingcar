package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    RacingCar racingCar = new RacingCar();

    @ParameterizedTest
    @DisplayName("random 값이 3 이하일때 값이 정상적으로 동작하는지 확인")
    @ValueSource(ints = {1, 2, 3})
    void tryToMoveZero(int randomRange) {
        racingCar.tryToMove(randomRange);
        assertThat(racingCar.getMovingRange()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("random 값이 4 이상일때 값이 정상적으로 동작하는지 확인")
    @ValueSource(ints = {4, 5, 6})
    void tryToMove(int randomRange) {
        assertThat(racingCar.tryToMove(randomRange)).isEqualTo(1);
    }
}
