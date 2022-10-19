package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racing_game.core.Positive;

class CarsTest {

    @Test
    void create() {
        List<CarName> carNames = List.of(
            new CarName("test1"), new CarName("test2"), new CarName("test3")
        );
        Cars cars = Cars.create(carNames);
        assertThat(cars).isNotNull();
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void moveAll() {
        List<CarName> carNames = List.of(
            new CarName("test1"), new CarName("test2"), new CarName("test3")
        );
        Cars cars = Cars.create(carNames);
        cars.moveAll(() -> true);
        cars.moveAll(() -> false);
        cars.moveAll(() -> true);

        Positive distances = cars.get()
            .get(new CarName("test1"))
            .getDistance();

        assertThat(distances.toInt()).isEqualTo(2);
    }

}
