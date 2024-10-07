package race;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import race.domain.FixedGoCondition;
import race.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @ParameterizedTest
    @CsvSource(value = {"false:0", "true:1"}, delimiter = ':')
    void 값이_4이상이면_전진_4미만이면_정지(boolean canGo, int expected) {
        // given
        RacingCar car = new RacingCar("car 1");

        // when
        car.move(new FixedGoCondition(canGo));

        // then
        assertThat(car.isStateEqualWith(expected)).isTrue();
    }

    @Test
    void 자동차_상태_메시지_검증() {
        // given
        RacingCar car = new RacingCar("car 1", 5);
        String expectedResult = "car 1 : -----";

        // when
        String result = car.toString();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
