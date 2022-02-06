package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.NameLengthOverException;

class RacingCarTest {

    @Test
    void 자동차의_이름_글자수_5자_이하_실패() {
        final String carName = "carcar1";

        assertThrows(NameLengthOverException.class, () -> new RacingCar(carName, 0));
    }

    @Test
    void 자동차의_이름_글자수_5자_이하_성공() {
        final String carName = "car1";

        assertDoesNotThrow(() -> new RacingCar(carName, 0));
    }

    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void canForward_전진실패(final int value) {
        final RacingCar car = new RacingCar("car", 0);

        car.forward(value);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void canForward_전진가능(final int value) {
        final RacingCar car = new RacingCar("car", 0);

        car.forward(value);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
