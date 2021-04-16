package racingcar.domains;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exceptions.StringLengthOverException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    @Test
    void racingCarAlwaysMoveTest() {
        RacingCar racingCar = new RacingCar("car");
        racingCar.move(() -> true);

        assertThat(racingCar.getMoveCnt()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"short", "car", "a"})
    void 다섯자이하_자동차_이름생성(String carName) {
        RacingCar racingCar = new RacingCar(carName);
        assertThat(racingCar.getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"longCarName", "shortCar", "carNameLong"})
    void 다섯자이상_자동차_이름생성(String carName) {
        assertThatThrownBy(() -> {
            new RacingCar(carName);
        }).isInstanceOf(StringLengthOverException.class)
            .hasMessageContaining("Car name is too long");
    }
}