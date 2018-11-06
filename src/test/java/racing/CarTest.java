package racing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car("test");
    }

    @Test
    public void addPositionTest() throws Exception {
        getRandomValue();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void getNameTest() {
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    public void getPositionTest() {
        getRandomValue();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    private void getRandomValue() {
        int randomValue = 5;
        car.addPosition(randomValue);
    }
}