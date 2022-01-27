package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingCarTest {

    @Test
    void 자동차이름검사_길이5초과() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new RacingCar("gdgdgdgdgdg");
            });
    }

    @ParameterizedTest
    @CsvSource(value = {"5:1", "2:0"}, delimiter = ':')
    void 앞으로전진(int moveNum, int expectedPosition) {
        RacingCar car = new RacingCar("testN");

        car.move(()-> moveNum);

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void 같은위치인지테스트() {
        RacingCar car = new RacingCar("test1", 5);

        boolean isSamePosition = car.isSamePosition(5);

        assertThat(isSamePosition).isEqualTo(true);
    }
}
