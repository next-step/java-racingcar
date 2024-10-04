package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
