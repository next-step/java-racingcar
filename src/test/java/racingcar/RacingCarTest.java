package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    @DisplayName("자동자 주행 테스트")
    void runTest() {
        // given
        RacingCar racingCar = new RacingCar();

        // when
        racingCar.run(() -> true);

        // then
        assertThat(racingCar.getCarPosition()).isPositive();
    }

}
