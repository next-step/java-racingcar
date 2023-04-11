package racingcar.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.service.RacingCar.moveIfOver4;
import static racingcar.service.RacingCar.race;
import static racingcar.service.RacingCar.move;
import static racingcar.service.RacingCar.stop;

public class RacingCarTest {
    @ParameterizedTest
    @CsvSource(value = {"0,false", "1,false", "2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true", "9,true"})
    void 숫자4이상이_나오면_전진(int number, boolean expected) {
        assertThat(moveIfOver4(number)).isEqualTo(expected);
    }

    @Test
    void 레이스() {
        assertThat(race(3)).hasSize(3);
    }

    @Test
    void 움직인다() {
        assertThat(move(3)).isEqualTo(4);
    }

    @Test
    void 멈춘다() {
        assertThat(stop(3)).isEqualTo(3);
    }
}
