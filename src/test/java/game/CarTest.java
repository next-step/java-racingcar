package game;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    RacingCar racingCar;

    @Before
    public void setUp() throws Exception {
        racingCar = new RacingCar();
    }

    @Test
    public void 움직일수있는값_4() {
        int beforeCount = racingCar.getMovingCount();
        racingCar.move(4);
        int afterCount = racingCar.getMovingCount();

        assertThat(afterCount).isEqualTo(beforeCount+1);
    }

    @Test
    public void 움직일수없는_3() {
        int beforeCount = racingCar.getMovingCount();
        racingCar.move(3);
        int afterCount = racingCar.getMovingCount();

        assertThat(afterCount).isEqualTo(beforeCount);
    }
}