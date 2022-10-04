package third;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import third.logic.Car;
import third.logic.Race;


public class RacingCarTest {

    @Test
    public void getRandomNumberTest() {
        int number = Race.getRandomNumber();
        assertThat(number).isBetween(0,9);
    }

    @Test
    public void MoveTest() {
        Car car = new Car();
        car.Move(4);
        assertThat(car.getCarLocation()).isEqualTo(2);
    }
}
