package step3;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car();
    }

    @Test
    public void 자동차_객체를_생성하고_현재_위치를_조회하면_0이_나온다() {
        assertThat(car.getCurrentLocation()).isEqualTo(0);
    }

    @Test
    public void random값이_4이상이면_현재_위치에서_한칸_전진한다() {
        car.move(4);
        assertThat(car.getCurrentLocation()).isEqualTo(1);
    }

    @Test
    public void random값이_4미만이면_현재_위치에서_이동하지_않는다() {
        car.move(3);
        assertThat(car.getCurrentLocation()).isEqualTo(0);
    }


}
