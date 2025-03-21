package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void 초기_상태의_distance는_0이다() {
        RacingCar car = new RacingCar(new RacingCarName("test"));
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,2", "1,1", "3,3"})
    void 이동에_성공했다면_distance가_1_증가한다(int moveCount, int expected) {
        RacingCar car = new RacingCar(new RacingCarName("test"));

        for (int i = 0; i < moveCount; i++) {
            car.moveIfMovable(() -> true);
        }

        assertThat(car.getDistance()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0", "1,0", "2,0"}, ignoreLeadingAndTrailingWhitespace = false)
    void 이동에_실패했다면_distance는_증가하지_않는다(int moveCount, int expected) {
        RacingCar car = new RacingCar(new RacingCarName("test"));

        for (int i = 0; i < moveCount; i++) {
            car.moveIfMovable(() -> false);
        }

        assertThat(car.getDistance()).isEqualTo(expected);
    }
}
