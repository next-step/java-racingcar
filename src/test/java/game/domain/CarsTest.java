package game.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsTest {

    @Test
    void 자동차_경주_이동_가능() {
        Cars cars = new Cars(List.of(new Car(0, "a"), new Car(0, "b"), new Car(0, "c")));

        cars.moveCarList(() -> true);

        for (Car car : cars.getCarList()) {
            Assertions.assertThat(car.getPosition()).isEqualTo(new Position(1));
        }
    }

    @Test
    void 자동차_경주_이동_불가능() {
        Cars cars = new Cars(List.of(new Car(0, "a"), new Car(0, "b"), new Car(0, "c")));

        cars.moveCarList(() -> false);

        for (Car car : cars.getCarList()) {
            Assertions.assertThat(car.getPosition()).isEqualTo(new Position(0));
        }
    }
}
