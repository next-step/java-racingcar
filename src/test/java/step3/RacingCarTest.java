package step3;

import step3.car.RacingCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private RacingCar car;

    @BeforeEach
    void setCar() {
        car = new RacingCar();
    }

    @DisplayName("입력값이 4이상이면 차가 전진, 4미만이면 정지한다.")
    @Test
    void forwardTest() {
        car.forward();
        assertThat(car.getDistance()).isEqualTo(1);
    }

}
