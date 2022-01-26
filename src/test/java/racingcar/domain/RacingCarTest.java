package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import racingcar.Application;
import racingcar.util.RandomUtil;

class RacingCarTest {

    @Test
    void 자동차이름검사_길이5초과() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new RacingCar("gdgdgdgdgdg");
            });
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 3 - 5:-1", "5 * 4 / 2:10"}, delimiter = ':')
    void 앞으로전진() {
        RacingCar car = new RacingCar("testN");

        car.moveForwardWithNum(5);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 같은위치인지테스트() {
        RacingCar car = new RacingCar("test1", 5);

        boolean isSamePosition = car.isSamePosition(5);

        assertThat(isSamePosition).isEqualTo(true);
    }
}
