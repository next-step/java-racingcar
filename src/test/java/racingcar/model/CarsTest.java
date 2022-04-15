package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차 객체 생성 확인")
    void confirmCarObjectCreation() {
        int numberOfCars = 3;

        Cars cars = new Cars(numberOfCars);

        assertThat(cars.getCars()).hasSize(numberOfCars);
    }
}