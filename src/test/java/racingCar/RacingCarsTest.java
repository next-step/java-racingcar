package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domain.RacingCar;
import racingCar.domain.RacingCars;

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
    void 제일_앞선_자동차_구하기() {
        RacingCar a = new RacingCar("a", 0);
        RacingCar b = new RacingCar("b", 1);
        RacingCar c = new RacingCar("c", 2);

        RacingCars cars = new RacingCars(List.of(a, b, c));

        assertThat(cars.maxPositionCar()).isEqualTo(c);
    }


    @Test
    void 우승자_한명일_때() {
        RacingCars cars = new RacingCars(List.of(
                new RacingCar("a", 3),
                new RacingCar("b", 4),
                new RacingCar("c", 5)
        ));

        assertThat(cars.winners()).isEqualTo(List.of(new RacingCar("c", 5)));
    }

    @Test
    void 우승자_여러명일_때() {
        RacingCars cars = new RacingCars(List.of(
                new RacingCar("a", 4),
                new RacingCar("b", 3),
                new RacingCar("c", 4)
        ));

        assertThat(cars.winners()).isEqualTo(List.of(
                new RacingCar("a", 4),
                new RacingCar("c", 4)
        ));
    }

    @Test
    void 경쟁자가_없을_때() {
        RacingCars cars = new RacingCars(List.of(
                new RacingCar("a", 3)
        ));

        assertThat(cars.winners()).isEqualTo(List.of(
                new RacingCar("a", 3)
        ));
    }
}
