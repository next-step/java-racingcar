package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {
    @Test
    void test_차추가하기() {
        Cars cars = new Cars();
        cars.addCar(new Car(3, "red"));
        cars.addCar(new Car(6, "black"));
        cars.addCar(new Car(2, "pink"));

        assertThat(cars.toString()).isEqualTo("Cars{cars=[red, black, pink]}");
    }
}