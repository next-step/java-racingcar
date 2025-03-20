package step3.racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.racingcar.controller.RacingCarController;


public class RacingCarTest {


    @Test
    @DisplayName("RacingCar::run() - GO")
    void givenAlwaysGoThreshold_whenRacingCarRun_thenRacingCarGo() {
        // given
        int no = 1;
        int threshold = 0;
        RacingCarEngine engine = new RacingCarEngine(threshold);
        RacingCar car = new RacingCar(no, engine);

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
        RacingCarEngine engine = new RacingCarEngine(threshold);
        RacingCar car = new RacingCar(no, engine);

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
