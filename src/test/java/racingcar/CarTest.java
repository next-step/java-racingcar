package racingcar;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CarTest {
    @Test
    public void 전진() {
        for (int i = 4; i <= 9; i++) {
            Car car = new Car();
            car.move(i);
            assertThat(car.getRacingPath(), is("-"));
        }
    }

    @Test
    public void 멈춤() {
        for (int i = 0; i < 4; i++) {
            Car car = new Car();
            car.move(i);
            assertThat(car.getRacingPath(), is(""));
        }
    }

    @Test
    public void 차의_상태_그리기() {
        Car car = new Car();
        car.move(4);
        car.move(6);
        assertThat(car.getRacingPath(), is("--"));
    }
}