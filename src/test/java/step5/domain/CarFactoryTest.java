package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class CarFactoryTest {


    @Test
    void createCars() {
        CarName carName1 = new CarName("1");
        CarName carName2 = new CarName("2");
        CarNames carNames = new CarNames(List.of(carName1, carName2));
        Cars cars = CarFactory.createCars(carNames);

        Assertions.assertThat(cars).isEqualTo(new Cars(List.of(
                new Car(carName1),
                new Car(carName2)
        )));
    }
}