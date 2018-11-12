package game;

import game.domain.Car;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car("Hello");
    }

    @Test
    public void 움직일수있는값_4() {
        int beforeCount = car.getLocation();
        car.move(4);
        int afterCount = car.getLocation();

        assertThat(afterCount).isEqualTo(beforeCount+1);
    }

    @Test
    public void 움직일수없는_3() {
        int beforeCount = car.getLocation();
        car.move(3);
        int afterCount = car.getLocation();

        assertThat(afterCount).isEqualTo(beforeCount);
    }
}