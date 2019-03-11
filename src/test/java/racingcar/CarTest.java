package racingcar;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CarTest {
    @Test
    public void 숫자4이상_전진() {
        for (int i = 4; i <= 9; i++) {
            Car car = new Car();
            car.move(new FixedNumberGenerator(i));
            assertThat(car.getPosition(), is(1));
        }
    }

    @Test
    public void 숫자4미만_멈춤() {
        for (int i = 0; i < 4; i++) {
            Car car = new Car();
            car.move(new FixedNumberGenerator(i));
            assertThat(car.getPosition(), is(0));
        }
    }
}