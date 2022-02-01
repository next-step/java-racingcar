package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
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

    @Test
    void 한_칸_전진() {
        final RacingCar car = new RacingCar("car", 0);

        car.forward();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void canForward_전진실패() {
        final int randomValue = 1;
        final RacingCar car = new RacingCar("car", 0);

        assertFalse(car.canForward(randomValue));
    }

    @Test
    void canForward_전진가능() {
        final int randomValue = 5;
        final RacingCar car = new RacingCar("car", 0);

        assertTrue(car.canForward(randomValue));
    }
}
