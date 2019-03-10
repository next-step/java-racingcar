package racing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Before
    public void setUp() {
        RacingGame.setNumberOfCar(3);
    }

    @Test
    public void initCarsTest() {
        int[] result = RacingGame.initCars();
        assertThat(result).isEqualTo(new int[3]);
    }

    @Test
    public void moveCarsTest() {
        //랜덤한 값에 대한 테스트?
    }
}
