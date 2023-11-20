package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarTest {

    @ParameterizedTest
    @DisplayName("경주차는 4이상의 수가 나오면 전진한다.")
    @CsvSource(value = {"4, 1", "3, 0"})
    void move(int randomNumber, int expectedPosition) {
        // given
        RacingCar racingCar = new RacingCar("tobi");

        // when
        racingCar.move(randomNumber);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar("tobi", expectedPosition));
    }

    @Test
    @DisplayName("자동차 이름으로 경주차를 만든다.")
    void create_racing_car_with_car_name() {
        // given
        String carName = "pobi";

        // when
        RacingCar racingCar = new RacingCar(carName);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar("pobi", 0));
    }

    @ParameterizedTest
    @DisplayName("이동한 거리만큼 DASH 를 그린다.")
    @CsvSource(value = {"3, ---", "6, ------", "0,''"})
    void create_dash_with_moving_distance(long given, String expected) {
        // given
        RacingCar racingCar = new RacingCar("k5", given);

        // when
        String result = racingCar.movingDistance();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("가장 큰 위치를 갱신한다.")
    @CsvSource(value = {"3, 4, 4", "6, 5, 6", "4, 0, 4"})
    void compare_position_and_tmp_max_position(long given, long when, long expected) {
        // given
        RacingCar racingCar = new RacingCar("k5", given);

        // when
        long result = racingCar.updateMaxPosition(when);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("경주차가 결승선에 위치해 있는지 확인한다.")
    @CsvSource(value = {"3, 4, false", "6, 6, true", "4, 0, false"})
    void validate_position_that_is_finish_line(long given, long when, boolean expected) {
        // given
        RacingCar racingCar = new RacingCar("k5", given);

        // when
        boolean result = racingCar.isLocated(when);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
