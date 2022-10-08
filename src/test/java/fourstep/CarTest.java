package fourstep;

import fourstep.logic.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class CarTest {

    @Test
    void moveTest() {
        Car car = new Car("busung");
        car.move(4);
        assertThat(car.getLocation()).isEqualTo(2);
    }
}
