package game.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsTest {

    @Test
    void 자동차_경주_이동_가능() {
        Cars cars = new Cars(List.of("a", "b", "c"));

        cars.moveCarList(() -> true);

        for (Car car : cars.getCarList()) {
            Assertions.assertThat(car.getPosition()).isOne();
        }
    }

    @Test
    void 자동차_경주_이동_불가능() {
        Cars cars = new Cars(List.of("a", "b", "c"));

        cars.moveCarList(() -> false);

        for (Car car : cars.getCarList()) {
            Assertions.assertThat(car.getPosition()).isZero();
        }
    }

    @Test
    void 높은_위치에_위치한_자동차_리스트_조회() {
        Cars cars = new Cars(List.of("a", "b", "c"));

        Assertions.assertThat(cars.getLocatedHighPositionCars()).isEqualTo(cars.getCarList());
    }
}
