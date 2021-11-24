package racing.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void createWithString() {
        Cars carsWithString = new Cars("su1,su2,su3");
        List<Car> carList = carsWithString.getCars();

        assertThat(carList.size()).isEqualTo(3);
        assertThat(carList).contains(new Car("su1"), new Car("su2"), new Car("su3"));
    }

    @Test
    void createWithCarList() {
        Car car1 = new Car("su1");
        Car car2 = new Car("su2");
        Car car3 = new Car("su3");
        List<Car> carList = Arrays.asList(car1, car2, car3);
        Cars cars2 = new Cars(carList);
        List<Car> result = cars2.getCars();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result).contains(new Car("su1"));
        assertThat(result).contains(new Car("su2"));
        assertThat(result).contains(new Car("su3"));
    }

    @Test
    void 우승자() {
        Car car1 = new Car(new Name("su1"), new Position(5));
        Car car2 = new Car(new Name("su2"), new Position(5));
        Car car3 = new Car(new Name("su3"), new Position());
        List<Car> carList = Arrays.asList(car1, car2, car3);
        Cars cars = new Cars(carList);

        assertThat(cars.winners()).contains(car1, car2);
    }
}