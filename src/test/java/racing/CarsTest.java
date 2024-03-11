package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsTest {

    @Test
    void constructor() {
        List<Car> carList = List.of(new Car("test"), new Car("nimoh"));
        Cars cars = new Cars(carList);

        Assertions.assertThat(cars).hasSize(2);
    }

}