package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class CarsTest {
    @Test
    void test_차추가하기() {
        Cars cars = new Cars();
        cars.addCar(new Car(3, "red"));
        cars.addCar(new Car(3, "black"));
        cars.addCar(new Car(2, "pink"));

        assertThat(cars.toString()).isEqualTo("Cars{cars=[red, black, pink]}");
    }

    @Test
    void test_우승자구하기() {
        Cars cars = new Cars();
        cars.addCar(new Car(3, "red"));
        cars.addCar(new Car(3, "black"));
        cars.addCar(new Car(2, "pink"));

        assertThat(cars.findWinners()).contains("red");
        assertThat(cars.findWinners()).contains("black");
    }
}