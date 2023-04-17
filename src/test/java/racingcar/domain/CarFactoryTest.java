package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarFactoryTest {
    @Test
    @DisplayName("이름을쉼표로구분하여생성")
    void 이름을쉼표로구분하여생성() {
        Car[] cars = CarFactory.createCars("benz,bmw,tesla");

        Assertions.assertThat(cars[0].getName()).isEqualTo("benz");
        Assertions.assertThat(cars[1].getName()).isEqualTo("bmw");
        Assertions.assertThat(cars[2].getName()).isEqualTo("tesla");
    }
}