package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdefg", ""})
    void 자동차이름_형식_유효성검증(String carName) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new RacingCar(new Name(carName));
            });
    }

    @ParameterizedTest
    @CsvSource(value = {"true:1", "flase:0"}, delimiter = ':')
    void 앞으로전진(boolean moveNum, int expectedPosition) {
        // given
        RacingCar car = new RacingCar(new Name("testN"));

        // when
        car.move(()-> moveNum);

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void 같은위치인지테스트() {
        // given
        RacingCar car = new RacingCar(new Name("test1"), 5);

        // when
        boolean isSamePosition = car.isSamePosition(5);

        // then
        assertThat(isSamePosition).isEqualTo(true);
    }
}
