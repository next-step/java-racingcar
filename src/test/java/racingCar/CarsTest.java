package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarsTest {
    @Test
    void init() {
        Cars cars = new Cars(new String[]{"hobi", "crong", "honux"});
        Assertions.assertThat(cars.value().size()).isEqualTo(3);
    }
    @Test
    void createCar() {
        Car hobi = new Car("hobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");

        List<Car> list = List.of(hobi, crong, honux);

        Cars cars = new Cars(list);

        Assertions.assertThat(cars.value()).hasSize(3);
    }
}
