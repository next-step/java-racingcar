package racing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {
    private RacingCar racingCar;

    @Before
    public void createRacingCarTest() {
        this.racingCar = new RacingCar("shin", 0);
    }

    @Test
    public void moveTest() {
        assertThat(this.racingCar.move(3)).isEqualTo(0);
        assertThat(this.racingCar.move(4)).isEqualTo(1);
    }

}