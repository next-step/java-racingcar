package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class TestRacingCar {
    RacingCar racingCar;

    @DisplayName("자동차 이름 길이")
    @ParameterizedTest
    @ValueSource(strings = {"1234, 12345, 123456"})
    void test_car_name(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingCar(name));
    }

    @DisplayName("자동차 1번 이동")
    @ParameterizedTest
    @CsvSource({"2"})
    void test_move_one_step(int result) {
        racingCar = new RacingCar("BMW", 1);
        racingCar.move(new GoStraightBehavior());
        assertThat(racingCar.getDistance())
                .isLessThanOrEqualTo(result);
    }

    @DisplayName("자동차 2번 이동")
    @ParameterizedTest
    @CsvSource({"3"})
    void test_move_two_step(int result) {
        racingCar = new RacingCar("BMW", 1);
        racingCar.move(new GoStraightBehavior());
        racingCar.move(new GoStraightBehavior());
        assertThat(racingCar.getDistance())
                .isLessThanOrEqualTo(result);
    }
}
