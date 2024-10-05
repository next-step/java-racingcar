package race;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import race.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @ParameterizedTest
    @CsvSource(value = {"0:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    void 값이_4이상이면_전진_4미만이면_정지(int number, int expected) {
        // given
        RacingCar car = new RacingCar("car 1");

        // when
        car.moveCarForwardIfCanGo(number);

        // then
        assertThat(car.state()).isEqualTo(expected);
    }

    @Test
    void 더_큰_상태값_반환() {
        // given
        int currentMaxState = 4;
        int currentCarState = 5;
        RacingCar car = new RacingCar("car 1", currentCarState);

        // when
        int result = car.max(currentMaxState);

        // then
        assertThat(result).isEqualTo(currentCarState);
    }

    @Test
    void 상태값_같은지_검증() {
        // given
        int currentCarState = 5;
        int inputState = 5;
        RacingCar car = new RacingCar("car 1", currentCarState);

        // when
        boolean result = car.isStateEqualWith(inputState);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 자동차_상태_메시지_검증() {
        // given
        RacingCar car = new RacingCar("car 1", 5);
        String expectedResult = "car 1 : -----";

        // when
        String result = car.makeCarStateMessage();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
