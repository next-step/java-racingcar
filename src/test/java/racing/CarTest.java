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
        int randomValue = 5;

        car.addPosition(randomValue);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void recordTest() throws Exception {
        int randomValue = 5;
        car.addPosition(randomValue);
        car.record(car.getPosition());

        assertThat(car.getRecord().size()).isEqualTo(1);
    }
}