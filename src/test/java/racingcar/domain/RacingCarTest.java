package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    @DisplayName("자동자 주행 테스트")
    void racingCar_run_test() {
        // given
        RacingCar racingCar = new RacingCar.RacingCarBuilder("YKJ")
                .carPosition(1)
                .build();

        // when
        racingCar.run(() -> true);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar.RacingCarBuilder("YKJ")
                .carPosition(2)
                .build());
    }

    @Test
    @DisplayName("자동자 정지 테스트")
    void racingCar_stop_test() {
        // given
        RacingCar racingCar = new RacingCar.RacingCarBuilder("YKJ")
                .carPosition(0)
                .build();

        // when
        racingCar.run(() -> false);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar.RacingCarBuilder("YKJ")
                .carPosition(0)
                .build());
    }

}
