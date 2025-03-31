import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void constructorUsingCarNum() {
        List<Car> carList = List.of(new Car("pobi"), new Car("crong"), new Car("honux"));
        assertThat(new Cars(carList).getCars().size()).isEqualTo(3);
    }

    @Test
    void getWinners() {
        assertThat(new Cars(List.of(new Car("pobi", 1), new Car("crong", 3), new Car("honux", 3))).getMaxPosition()).isEqualTo(3);
    }

    @Test
    void getMaxPosition() {
        assertThat(new Cars(List.of(new Car("pobi", 1), new Car("crong", 2), new Car("honux", 3))).getMaxPosition()).isEqualTo(3);
    }

    @Test
    void getNames() {
        assertThat(new Cars(List.of(new Car("pobi", 1), new Car("crong", 2), new Car("honux", 3))).getNames()).isEqualTo("pobi,crong,honux");
    }

    @Test
    void getByPosition() {
        final Cars cars = new Cars(List.of(new Car("pobi", 1), new Car("crong", 2), new Car("honux", 3)));
        assertThat(cars.getByPosition(1)).isEqualTo(List.of(new Car("pobi", 1)));
        assertThat(cars.getByPosition(2)).isEqualTo(List.of(new Car("crong", 2)));
        assertThat(cars.getByPosition(3)).isEqualTo(List.of(new Car("honux", 3)));
    }
}
