package racingcar.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void moveForward() {
        RacingCar racingCar = new RacingCar();
        racingCar.moveForward();
        racingCar.moveForward();
        racingCar.moveForward();

        assertThat(racingCar.getMovePath()).isEqualTo("---");
    }

}