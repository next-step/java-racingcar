package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차의 이동 여부를 결정하는 random 값은 0에서 9사이이다.")
    void carMoveException() {
        // given
        RacingCar car = new RacingCar();

        // when
        int randomInt = car.getRandomInt();

        // then
        assertThat(randomInt).isLessThan(10);
        assertThat(randomInt).isGreaterThan(-1);
    }

    @ParameterizedTest
    @DisplayName("자동차는 random 값이 4이상 9이하일 경우 이동하고, 0이상 3이하일 경우 정지한다.")
    @CsvSource(value = {"1:0", "2:0", "6:1", "7:1"}, delimiter = ':')
    void move(int randomInt, int distance) {
        // given
        RacingCar car = new RacingCar();

        // when
        car.move(randomInt);

        // then
        assertThat(car.getDistance()).isEqualTo(distance);
    }
}
