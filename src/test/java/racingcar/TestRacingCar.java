package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRacingCar {
    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar(new GoStraightBehavior());
    }

    @DisplayName("자동차 1번 이동")
    @ParameterizedTest
    @CsvSource({"1"})
    void test_move_one_step(int result) {
        racingCar.move();
        assertThat(racingCar.getDistance())
                .isLessThanOrEqualTo(result);
    }

    @DisplayName("자동차 2번 이동")
    @ParameterizedTest
    @CsvSource({"2"})
    void test_move_two_step(int result) {
        racingCar.move();
        racingCar.move();
        assertThat(racingCar.getDistance())
                .isLessThanOrEqualTo(result);
    }
}
