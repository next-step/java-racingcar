package racingcarbasic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 이름_검증() {
        ValidationName validationName = new ValidationName();
        assertThatThrownBy(() -> {
            validationName.validateName(new String[]{"ccccccc", "a", "abc"});
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전부_우승자일_경우() {
        String[] nameList = {"a", "car", "eeee", "rrrr", "ff"};
        RacingCars racingCars = RacingCars.of(nameList, () -> true);
        racingCars.moveCars();

        assertThat(racingCars.getWinners()).isEqualTo(Arrays.asList(nameList));
    }
}
