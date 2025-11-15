package racinggame.car;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차_갯수만큼_자동차객체를_생성할_수_있다() {
        List<String> carNames = of("first", "second", "third");
        Cars cars = Cars.createByNames(carNames);

        assertThat(
                cars.size()
        ).isEqualTo(3);
    }

    @Test
    void 자동차들이_가진_포지션값중_가장_큰_값을_찾아낼_수_있다() {
        Car first = new Car("first");
        first.updatePosition(5);
        Car second = new Car("second");
        Car third = new Car("third");

        Cars cars = new Cars(of(first, second, third));

        assertThat(
                cars.findMaxPositions()
        ).isEqualTo(5);
    }

    @Test
    void 포지션값중_가장_큰_값으로_우승차량을_찾아낼_수_있다() {
        Car first = new Car("first");
        first.updatePosition(5);
        Car second = new Car("second");
        second.updatePosition(5);
        Car third = new Car("third");

        Cars cars = new Cars(of(first, second, third));

        assertThat(
                cars.findWinners(5)
        ).containsExactly("first", "second");
    }
}