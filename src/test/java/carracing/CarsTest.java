package carracing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 이동_수행() {
        List<String> names = Arrays.asList("A", "B", "C");
        Cars cars = new Cars(names);
        assertThat(cars.move(() -> true)).containsExactly(
                new Car("A", 1),
                new Car("B", 1),
                new Car("C", 1)
        );
    }

    @Test
    void 가장_큰_위치_찾기() {
        List<String> names = Arrays.asList("A", "B", "C");
        Cars cars = new Cars(names);
        cars.move(() -> true);
        assertThat(cars.findBiggestPosition()).isEqualTo(new Position(1));
    }

    @Test
    void 우승자_찾기() {
        List<String> names = Arrays.asList("A", "B", "C");
        Cars cars = new Cars(names);
        cars.move(() -> true);
        Position biggestPosition = cars.findBiggestPosition();
        assertThat(cars.findWinner(biggestPosition)).containsExactly(
                new Car("A", 1),
                new Car("B", 1),
                new Car("C", 1)
        );


    }
}
