package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    RacingCar car;
    @BeforeEach
    void init(){
        car = new RacingCar(new StringBuilder(""));
    }
    @Test
    void random값은_0_9_사이이다() throws Exception {
        assertThat(car.getRandomInt()).isLessThan(10);
    }
    @Test
    void random값이_4이상_전진() throws Exception {
        //given
        //when
        //then
    }
    @Test
    void random값이_4미만_멈춤() throws Exception {
        //given
        //when
        //then
    }

}
