package racing.model;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarTest {

    @Test
    public void test_이동_임계점미달() {
        RacingCar car = new RacingCar();
        assertThat(car.move(0)).isEqualTo(0);
    }

    @Test
    public void test_이동_임계점통과() {
        RacingCar car = new RacingCar();
        assertThat(car.move(RacingCar.THRESHOLD_POWER)).isEqualTo(1);
    }

    @Test
    public void test_이동_3회() {
        RacingCar car = new RacingCar();
        assertThat(car.move(RacingCar.THRESHOLD_POWER)).isEqualTo(1);
        assertThat(car.move(RacingCar.THRESHOLD_POWER)).isEqualTo(2);
        assertThat(car.move(RacingCar.THRESHOLD_POWER)).isEqualTo(3);
    }

    @Test
    public void test_위치_확인() {
        RacingCar car = new RacingCar();
        assertThat(car.isAt(1)).isFalse();

        car.move(RacingCar.THRESHOLD_POWER);
        assertThat(car.isAt(1)).isTrue();
    }
}