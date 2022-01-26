package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void 자동차이름_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new RacingCar().isCorrectNameSize("dasdfd");
            });
    }

    @Test
    void 앞으로전진() {
        RacingCar car = new RacingCar("testN");
        car.moveForward(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
