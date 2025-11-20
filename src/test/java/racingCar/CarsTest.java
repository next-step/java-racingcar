package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingCar.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void init() {
        Cars cars = new Cars(new String[]{"hobi", "crong", "honux"});
        Assertions.assertThat(cars.value()).hasSize(3);
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

    @Test
    void 우승자_출력() {
        Car pobi = new Car(new Name("pobi"), new Distance(5));
        Car crong = new Car(new Name("crong"), new Distance(2));
        Car honux = new Car(new Name("honux"), new Distance(2));

        Cars cars = new Cars(Arrays.asList(pobi, crong, honux));

        Winners winners = cars.getWinners();

        assertThat(winners.value()).contains(pobi);
    }
}
