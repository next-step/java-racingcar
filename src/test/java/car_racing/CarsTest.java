package car_racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("When create cars, the id will start from 0")
    void createCars_check_ids() {
        // given
        int numberOfCount = 3;

        // when
        Cars cars = new Cars(numberOfCount);
        Car car0 = new Car(0);
        Car car1 = new Car(1);
        Car car2 = new Car(2);

        // then
        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0)).isEqualTo(car0);
        assertThat(cars.getCars().get(1)).isEqualTo(car1);
        assertThat(cars.getCars().get(2)).isEqualTo(car2);
    }

    @Test
    @DisplayName("When 0 cars, returns empty list")
    void createCars_with_zero_car() {
        // given
        int numberOfCount = 0;

        // then
        Cars cars = new Cars(0);

        // when
        assertThat(cars.getCars()).isEmpty();
        assertThat(cars.getCars().size()).isEqualTo(0);
    }

}