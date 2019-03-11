package racing;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Before
    public void setUp() {
        RacingGame.setNumberOfCar(3);
    }

    @Test
    public void initCarsTest() {
        //List<Car> result = RacingGame.initCars();
        //assertThat(result).isEqualTo(new Car[3]);
    }

    @Test
    public void moveCarsTest() {
        //랜덤한 값에 대한 테스트?
    }
}
