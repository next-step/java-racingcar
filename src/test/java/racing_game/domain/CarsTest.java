package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racing_game.core.Positive;

class CarsTest {

    @Test
    void create() {
        Cars cars = Cars.create(Positive.of(3));
        assertThat(cars).isNotNull();
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void moveAll() {
        Cars cars = Cars.create(Positive.of(3));
        cars.moveAll();
        cars.moveAll();
        cars.moveAll();

        List<Positive> distances = cars.toList()
            .stream()
            .map(Car::getDistance)
            .collect(Collectors.toUnmodifiableList());

        assertThat(distances).containsAnyOf(Positive.of(0), Positive.of(1), Positive.of(2));
    }
}
