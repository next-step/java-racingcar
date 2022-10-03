package racing.model;

import org.junit.jupiter.api.Test;
import racing.service.RacingGameService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void 가장_멀리_이동한_차가_우승자이다() {
        Cars cars = new Cars();
        cars.add(new Car("a", 2));
        cars.add(new Car("b", 4));
        cars.add(new Car("c", 3));

        assertThat(cars.getWinners().get(0)).isEqualTo(new Car("b", 4));
    }

    @Test
    void 우승자_계산을_위하여_가장_멀리간_우승자의_거리를_반환한다() {
        Cars cars = new Cars();
        cars.add(new Car("a", 2));
        cars.add(new Car("b", 4));
        cars.add(new Car("c", 3));

        assertThat(cars.getWinnerPosition()).isEqualTo(4);
    }
}
