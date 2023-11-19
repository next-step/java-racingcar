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
}
