package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCarsTest {

    @Test
    void 우승한_차_가져오기() {
        Car car1 = new Car(new CarName("car1"), 1);
        Car car2 = new Car(new CarName("car2"), 2);
        Car car3 = new Car(new CarName("car3"), 7);
        Car car4 = new Car(new CarName("car4"), 7);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        assertThat(WinnerCars.getWinnerCars(cars)).isNotEmpty();
        assertThat(WinnerCars.getWinnerCars(cars)).containsExactly(car3, car4);
    }

}
