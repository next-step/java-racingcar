package step3;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    public void 자동차_객체를_생성하고_현재_위치를_조회하면_0이_나온다() {
        Car car = new Car();
        assertThat(car.getCurrentLocation()).isEqualTo(0);
    }


}
