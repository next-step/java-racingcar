package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.utils.RandomGenerator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {
    private RacingCar racingCar;
    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }
    @Test
    @DisplayName("전진조건 만족시 전진한다")
    void move_the_car() {
        racingCar.move(()->true);
        assertThat(racingCar.positionOfRacingCar()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진조건 불만족시 정지한다")
    void stop_the_car() {
        racingCar.move(()->false);
        assertThat(racingCar.positionOfRacingCar()).isEqualTo(0);
    }

}
