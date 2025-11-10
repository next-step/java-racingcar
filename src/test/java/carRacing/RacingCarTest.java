package carRacing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @ParameterizedTest
    @DisplayName("4이상의 값이면 전진한다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_success(int input) {
        racingCar.move(input);
        Assertions.assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("3이하의 값이면 멈춘다")
    @ValueSource(ints = {1, 2, 3})
    void move_fail(int input) {
        racingCar.move(input);
        Assertions.assertThat(racingCar.getPosition()).isEqualTo(0);
    }
}