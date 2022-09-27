import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    public void 전진() {
        Car car = new Car(0);

        int expectedFirstStep = 1;
        int expectedSecondStep = 2;

        assertThat(car.move(4)).isEqualTo(expectedFirstStep);
        assertThat(car.move(9)).isEqualTo(expectedSecondStep);
    }

    @Test
    public void 멈춤() {
        Car car = new Car(0);

        int expectedFirstStep = 0;
        int expectedSecondStep = 0;

        assertThat(car.move(0)).isEqualTo(expectedFirstStep);
        assertThat(car.move(3)).isEqualTo(expectedSecondStep);
    }

    @Test
    public void 속도() {
        Car car = new Car(0);

        assertThat(car.speedOf()).isBetween(0, 9);
    }
}
