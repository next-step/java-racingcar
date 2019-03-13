package racing;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @Test
    public void moveTrueTest() {
        RacingCar racingCar = new RacingCar("shin, yeon");
        racingCar.move(RandomNumberUtil.returnParamNumber(4));
        racingCar.toString();
    }

    @Test
    public void moveFalseTest() {
        RacingCar racingCar = new RacingCar("shin, yeon");
        racingCar.move(RandomNumberUtil.returnParamNumber(5));
        racingCar.toString();
    }
}