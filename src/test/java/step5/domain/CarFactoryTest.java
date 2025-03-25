package step5.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarFactoryTest {

    @Test
    void createCarsByStrings() {
        Cars cars = CarFactory.createCars(new String[]{"1", "2"});

        assertThat(cars).isEqualTo(new Cars(List.of(
                new Car("1"),
                new Car("2")
        )));
    }
}