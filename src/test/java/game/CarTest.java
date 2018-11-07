package game;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car();
    }

    @Test
    public void 움직일수있는값_9() {
        int beforeCount = car.getMovingCount();
        car.move(9);
        int afterCount = car.getMovingCount();

        assertThat(afterCount).isEqualTo(beforeCount+1);
    }

    @Test
    public void 움직일수없는_1() {
        int beforeCount = car.getMovingCount();
        car.move(1);
        int afterCount = car.getMovingCount();

        assertThat(afterCount).isEqualTo(beforeCount);
    }
}