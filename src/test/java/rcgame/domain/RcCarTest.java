package rcgame.domain;

import org.junit.Before;
import org.junit.Test;
import rcgame.util.TestNumberGenerator;

import static org.assertj.core.api.Assertions.*;
import static rcgame.domain.RcCar.MOVE_BOUND_VALUE;

public class RcCarTest {

    TestNumberGenerator testNumberGenerator = new TestNumberGenerator();

    @Before
    public void setup() {
        RcCar.setNumberGenerator(testNumberGenerator);
    }

    @Test
    public void 자동차의_출발_위치는_0이다() {
        //when given
        RcCar car = new RcCar("test");
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 자동차는_랜덤값이_4이상일_경우_전진한다() {
        //when given
        RcCar car = new RcCar();
        testNumberGenerator.setTestNumber(MOVE_BOUND_VALUE);
        //then
        assertThat(car.move().getPosition()).isEqualTo(1);
    }

    @Test
    public void 자동차는_랜덤값이_4미만일_경우_정지된다() {
        //when given
        RcCar car = new RcCar();
        testNumberGenerator.setTestNumber(MOVE_BOUND_VALUE - 1);
        //then
        assertThat(car.move().getPosition()).isEqualTo(0);
    }
}