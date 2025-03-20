package step4.racingcar2.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.racingcar.controller.RacingCarController;
import step3.racingcar.model.RacingCar;
import step3.racingcar.model.RacingCarEngine;


public class RacingCarTest {


    @Test
    @DisplayName("RacingCar::run() - GO")
    void givenAlwaysGoThreshold_whenRacingCarRun_thenRacingCarGo() {
        // given
        int no = 1;
        int threshold = 0;
        step3.racingcar.model.RacingCarEngine engine = new step3.racingcar.model.RacingCarEngine(threshold);
        step3.racingcar.model.RacingCar car = new step3.racingcar.model.RacingCar(no, engine);

        // when
        int beforeRunPosition = car.position();
        RacingCarController carController = new RacingCarController();
        carController.ready(car);
        carController.run();
        int afterRunPosition = car.position();

        // then
        assertThat(afterRunPosition - beforeRunPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("RacingCar::run() - STOP")
    void givenAlwaysStopThreshold_whenRacingCarRun_thenRacingCarStop() {
        // given
        int no = 1;
        int threshold = 9;
        step3.racingcar.model.RacingCarEngine engine = new RacingCarEngine(threshold);
        step3.racingcar.model.RacingCar car = new RacingCar(no, engine);

        // when
        int beforeRunPosition = car.position();
        RacingCarController carController = new RacingCarController();
        carController.ready(car);
        carController.run();
        int afterRunPosition = car.position();

        // then
        assertThat(afterRunPosition - beforeRunPosition).isEqualTo(0);
    }

}
