package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void 가장_멀리_이동한_차가_우승자이다() {
        Car a = new Car("a", 2);
        Car b = new Car("b", 3);
        Car c = new Car("c", 3);
        List<Car> testCars = Arrays.asList(a, b, c);

        assertThat(new Cars().getWinners(testCars)).containsExactly(b, c);
    }

    @Test
    void 우승자_계산을_위하여_가장_멀리간_우승자의_거리를_반환한다() {
        Car a = new Car("a", 2);
        Car b = new Car("b", 3);
        Car c = new Car("c", 3);
        List<Car> testCars = Arrays.asList(a, b, c);

        assertThat(new Cars().getWinnerPosition(testCars)).isEqualTo(3);
    }
}
