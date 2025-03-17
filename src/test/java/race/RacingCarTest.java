package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    void should_move_over_4() {
        RacingCar car = new RacingCar();
        assertThat(car.shouldMove(4)).isTrue();
        assertThat(car.shouldMove(9)).isTrue();
    }

    @Test
    void should_not_move_under_4() {
        RacingCar car = new RacingCar();
        assertThat(car.shouldMove(3)).isFalse();
        assertThat(car.shouldMove(0)).isFalse();
    }
}
