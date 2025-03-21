package step4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarFactoryTest {

    @Test
    void CarFactory_는_자동차를_생성한다() {
        List<Car> cars = CarFactory.createCars(new String[]{"1", "2"});

        assertThat(cars).containsExactly(
                new Car(new CarName("1")),
                new Car(new CarName("2"))
        );
    }
}