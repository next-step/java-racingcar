package game.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차_경주_이동_가능() {
        Cars cars = new Cars(3);

        cars.moveCarList(() -> true);

        for (Car car : cars.getCarList()) {
            Assertions.assertThat(car.getPosition()).isOne();
        }
    }

    @Test
    void 자동차_경주_이동_불가능() {
        Cars cars = new Cars(3);

        cars.moveCarList(() -> false);

        for (Car car : cars.getCarList()) {
            Assertions.assertThat(car.getPosition()).isZero();
        }
    }
}
