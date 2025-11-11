package carRacing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {

    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar("kim");
    }

    @Test
    @DisplayName("racingCar 생성 시 이름이 필요하다")
    void racingCarName() {
        assertThat(racingCar.getName()).isEqualTo("kim");
    }

    @ParameterizedTest
    @DisplayName("4이상의 값이면 전진한다")
    @ValueSource(ints = {4, 9})
    void move_success(int input) {
        racingCar.move(input);
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("3이하의 값이면 멈춘다")
    @ValueSource(ints = {1, 3})
    void move_fail(int input) {
        racingCar.move(input);
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }
}