import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @DisplayName("이동 조건이 만족하면 움직인다.")
    @Test
    void move() {
        RacingCar car = new RacingCar(() -> true);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("이동 조건이 만족하지 않으면 움직이지 않는다.")
    @Test
    void stop() {
        RacingCar car = new RacingCar(() -> false);

        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }

}