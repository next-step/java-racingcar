package car_racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void createCars() {
        // given
        int numberOfCount = 3;

        // when
        Cars cars = new Cars(numberOfCount);

        // then
        assertThat(cars.getCarCount()).isEqualTo(3);
    }

    @Test
    void getCarsCurrStatuses() {
        // given
        Car[] arrCars = new Car[3];
        arrCars[0] = new Car("-");
        arrCars[1]= new Car("--");
        arrCars[2] = new Car("---");
        Cars cars = new Cars(arrCars);

        // when
        String carsCurrStatuses = cars.getCarsCurrStatuses();

        // then
        assertThat(carsCurrStatuses).isEqualTo("-\n--\n---\n\n");
    }
}