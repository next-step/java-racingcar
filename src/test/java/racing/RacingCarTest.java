package racing;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @Test
    public void moveTrueTest() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(new NumberWithParameter(4));
        String carPosition = racingCar.carPosition();
        assertThat(carPosition).isEqualTo("-");
    }

    @Test
    public void moveFalseTest() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(new NumberWithParameter(3));
        String carPosition = racingCar.carPosition();
        assertThat(carPosition).isEqualTo("");
    }
}