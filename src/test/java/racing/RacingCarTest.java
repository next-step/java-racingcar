package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.model.RacingCar;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    RacingCar car;
    @BeforeEach
    void init(){
        car = new RacingCar(0);
    }
    @Test
    void random값은_0_9_사이이다() throws Exception {
        assertThat(car.getRandomInt()).isLessThan(10);
    }
    @Test
    void random값이_4이상_전진() throws Exception {
        // given
        int randomInt = 9;
        int beforeProgress = car.getProgress();
        // when
        car.race(randomInt);
        // then
        assertThat(beforeProgress + 1).isEqualTo(car.getProgress());
    }
    @Test
    void random값이_4미만_멈춤() throws Exception {
        // given
        int randomInt = 3;
        int beforeProgress = car.getProgress();
        // when
        car.race(randomInt);
        // then
        assertThat(beforeProgress).isEqualTo(car.getProgress());
    }

}
