package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @Test
    void 생성된_RacingCar의_초기위치는_0(){
        RacingCar car = new RacingCar();
        assertThat(car.findCurrentLocation()).isEqualTo(0);
    }

}
