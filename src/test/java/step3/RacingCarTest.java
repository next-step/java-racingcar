package step3;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    RacingCar rc = new RacingCar();
    int car = 3;
    int count = 5;

    @Test
    void 차_대수만큼_리스트_사이즈() {
        Assertions.assertThat(rc.initCars(car)).hasSize(car);
    }
}
