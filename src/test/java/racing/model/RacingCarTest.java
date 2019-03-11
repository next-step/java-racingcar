package racing.model;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarTest {

    private final static int POWER_GREATER_THAN_THRESHOLD = 10;

    private final static int POWER_LESS_THAN_THRESHOLD = 0;


    @Test
    public void test_이동_임계점미달() {
        RacingCar car = new RacingCar();
        assertThat(car.move(POWER_LESS_THAN_THRESHOLD)).isEqualTo(0);
    }

    @Test
    public void test_이동_임계점통과() {
        RacingCar car = new RacingCar();
        assertThat(car.move(POWER_GREATER_THAN_THRESHOLD)).isEqualTo(1);
    }

    @Test
    public void test_이동_3회() {
        RacingCar car = new RacingCar();
        assertThat(car.move(POWER_GREATER_THAN_THRESHOLD)).isEqualTo(1);
        assertThat(car.move(POWER_GREATER_THAN_THRESHOLD)).isEqualTo(2);
        assertThat(car.move(POWER_GREATER_THAN_THRESHOLD)).isEqualTo(3);
    }

    @Test
    public void test_변환_DTO() {
        RacingCar racingCar = new RacingCar();
        assertThat(racingCar.mapToDto().getPosition()).isEqualTo(0);
        assertThat(racingCar.mapToDto().getName()).isEqualTo(racingCar.toString());
    }
}