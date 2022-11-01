package racingCar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    @Test
    void 자동차_목록_초기화() {
        assertThat(new RacingCars(new String[]{"a", "b", "c"})).isEqualTo(new RacingCars(List.of(
                new RacingCar("a"),
                new RacingCar("b"),
                new RacingCar("c")
        )));
    }

    @Test
    void 제일_앞선_자동차() {
        RacingCar a = new RacingCar("a", 0);
        RacingCar b = new RacingCar("b", 1);
        RacingCar c = new RacingCar("c", 2);

        RacingCars cars = new RacingCars(List.of(a, b, c));

        assertThat(cars.maxPositionCar()).isEqualTo(c);
    }
}
