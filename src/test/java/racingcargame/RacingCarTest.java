package racingcargame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcargame.model.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar("yerim");
    }

    @DisplayName(value = "자동차는 움직인다.")
    @Test
    void move() {
        racingCar.move(true);
        assertThat(racingCar.getStep()).isEqualTo(1);
    }

    @DisplayName(value = "자동차는 움직이지 않는다.")
    @Test
    void stop() {
        racingCar.move(false);
        assertThat(racingCar.getStep()).isEqualTo(0);
    }

    @DisplayName(value = "자동차가 우승자이다.")
    @Test
    void is_winner() {
        assertThat(racingCar.isWinner(0)).isTrue();

        for (int i = 0; i < 3; i++) {
            racingCar.move(true);
        }
        assertThat(racingCar.isWinner(3)).isTrue();

        for (int i = 0; i < 3; i++) {
            racingCar.move(true);
        }
        assertThat(racingCar.isWinner(6)).isTrue();
    }
}
