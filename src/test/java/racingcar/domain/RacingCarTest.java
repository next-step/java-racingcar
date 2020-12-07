package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    @DisplayName("자동자 주행 테스트")
    void racingCar_run_test() {
        // given
        RacingCar racingCar = new RacingCar();

        // when
        racingCar.run(() -> true);

        // then
        assertThat(racingCar.getCarPosition()).isEqualTo(1);
    }

}
