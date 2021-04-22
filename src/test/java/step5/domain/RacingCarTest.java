package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {

    @Test
    @DisplayName("자동차 이름 길이 확인")
    void testNameLength() {
        RacingCar car = new RacingCar("zoe");

        assertThat(car).isInstanceOf(RacingCar.class);
    }

    @Test
    @DisplayName("자동차 이름 길이 예외 확인")
    void testNameLengthException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    RacingCar car = new RacingCar("phoebe");
                });
    }

    @Test
    @DisplayName("자동차가 이동하지 않는 경우 확인")
    void testRunFail() {
        RacingCar car = new RacingCar("carin");
        int result = car.run(() -> false);
        assertThat(result).isEqualTo(0);

    }

    @Test
    @DisplayName("자동차가 이동하는 경우 확인")
    void testRunSuccess() {
        RacingCar car = new RacingCar("carin");
        int result = car.run(() -> true);
        assertThat(result).isEqualTo(1);
    }

}