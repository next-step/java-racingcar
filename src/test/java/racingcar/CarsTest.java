package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarsTest {

    private static final RandomPicker winNumberPicker = () -> GameNumber.newNumber(GameNumber.MOVABLE_MIN_NUMBER);

    private static Car car(String name, int grade) {
        Car car = Car.create(name, winNumberPicker);

        for (int idx = 0; idx < grade; idx++) {
            car.game();
        }

        return car;
    }

    @Test
    void winnerNames_가장_많이_이동한_자동차가_우승자이다() {
        // given
        String winnerName = "pobi";
        Cars cars = Cars.fromCars(List.of(car("crong", 1),
                car("honux", 2),
                car(winnerName, 3)));
        // when
        List<String> winnerNames = cars.winnerNames();

        // then
        assertThat(winnerNames).hasSize(1);
        assertThat(winnerNames.get(0)).isEqualTo(winnerName);
    }

    @Test
    void winnerNames_우승자는_1명_이상일_수_있다() {
        // given
        String winnerName1 = "pobi";
        String winnerName2 = "honux";
        Cars cars = Cars.fromCars(List.of(car("crong", 1),
                car(winnerName1, 3),
                car(winnerName2, 3)));
        // when
        List<String> winnerNames = cars.winnerNames();

        // then
        assertThat(winnerNames).hasSize(2);
        assertAll(
                () -> assertThat(winnerNames).contains(winnerName1),
                () -> assertThat(winnerNames).contains(winnerName2)
        );
    }
}
