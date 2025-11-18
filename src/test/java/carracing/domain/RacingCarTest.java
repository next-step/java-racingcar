package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @ParameterizedTest
    @DisplayName("4이상의 값이면 전진")
    @ValueSource(ints = {4, 9})
    void move_success(int input) {
        RacingCar car = new RacingCar("kim");
        car.move(input);
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @ParameterizedTest
    @DisplayName("3이하의 값이면 제자리")
    @ValueSource(ints = {1, 3})
    void move_fail(int input) {
        RacingCar car = new RacingCar("kim");
        car.move(input);
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }


}