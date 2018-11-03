package racing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car();
    }

    @Test
    public void addPositionTest() throws Exception {
        car.addPosition();
        assertThat(car.getPosition()).isEqualTo(1);
    }

}