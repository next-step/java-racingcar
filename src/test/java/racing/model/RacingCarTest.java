package racing.model;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarTest {

    final static int POWER_GREATER_THAN_THRESHOLD = 10;

    final static int POWER_LESS_THAN_THRESHOLD = 0;

    @Test
    public void test_이동_임계점미달() {
        RacingCar car = new RacingCar();
        assertThat(car.move(POWER_LESS_THAN_THRESHOLD)).isFalse();
    }

    @Test
    public void test_이동_임계점통과() {
        RacingCar car = new RacingCar();
        assertThat(car.move(POWER_GREATER_THAN_THRESHOLD)).isTrue();
    }

    @Test
    public void test_세번_이동() {
        RacingCar car = new RacingCar();
        car.move(POWER_GREATER_THAN_THRESHOLD);
        car.move(POWER_GREATER_THAN_THRESHOLD);
        car.move(POWER_GREATER_THAN_THRESHOLD);
        assertThat(car.getPosition()).isEqualTo(3);
    }
}