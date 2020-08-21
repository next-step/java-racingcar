package racingcarbasic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class RacingCarTest {

    @Test
    void 전진() {
        String[] name = {"car", "car", "car", "car", "car"};
        RacingCars racingCars = RacingCars.of(name, () -> true);
        racingCars.moveCars();

        assertThat(racingCars.getCarList()).allMatch(car -> car.getStep() == 1);
    }

    @Test
    void 멈춤() {
        String[] name = {"car", "car", "car", "car", "car"};
        RacingCars racingCars = RacingCars.of(name, () -> false);
        racingCars.moveCars();

        assertThat(racingCars.getCarList()).allMatch(car -> car.getStep() == 0);
    }


}
