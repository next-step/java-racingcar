package thirdstep;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import thirdstep.logic.Car;
import thirdstep.logic.Race;


public class RacingCarTest {

    @Test
    public void getRandomNumberTest() {
        int number = Race.getRandomNumber();
        assertThat(number).isBetween(0,9);
    }

    @Test
    public void carMoveTest() {
        Car car = new Car();
        car.carMove(4);
        assertThat(car.getCarLocation().length()).isEqualTo(2);
    }
}
