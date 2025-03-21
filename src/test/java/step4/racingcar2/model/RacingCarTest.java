package step4.racingcar2.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.racingcar2.exception.RacingCarException;
import step4.racingcar2.model.RacingCar;
import step4.racingcar2.model.RacingCarEngine;


public class RacingCarTest {

    @Test
    @DisplayName("고장난 엔진을 달았을 때 자동차가 앞으로 못가는지")
    void givenAlwaysStopThreshold_whenRacingCarRun_thenRacingCarStop() {
        // given
        String carName = "asdf";
        int alwaysStopThreshold = 10;
        RacingCar car = new RacingCar(new RacingCarName(carName), new RacingCarEngine(alwaysStopThreshold));

        // when
        int beforeRunPosition = car.position();
        car.run();
        int afterRunPosition = car.position();

        // then
        assertThat(afterRunPosition - beforeRunPosition).isEqualTo(0);
    }

    @Test
    @DisplayName("베스트 엔진을 달았을 때 자동차가 앞으로 가는지")
    void givenAlwaysGoThreshold_whenRacingCarRun_thenRacingCarGo() {
        // given
        String carName = "qwer";
        int threshold = 0;
        RacingCar car = new RacingCar(new RacingCarName(carName), new RacingCarEngine(threshold));

        // when
        int beforeRunPosition = car.position();
        car.run();
        int afterRunPosition = car.position();

        // then
        assertThat(afterRunPosition - beforeRunPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 위치 초기화 실패")
    void givenInvalidPosition_whenCreateRacingCar_thenThrowException() {
        // given
        String carName = "qwer";
        int invalidPosition = -1;

        // when
        assertThatThrownBy(() -> new RacingCar(new RacingCarName(carName), new RacingCarEngine(), invalidPosition))

            // then
            .isExactlyInstanceOf(RacingCarException.class);
    }

}
