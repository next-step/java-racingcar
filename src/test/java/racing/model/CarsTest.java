package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

//    private static Cars cars;
//
//    @Test
//    void init() {
//        List<Car> carList = new LinkedList<>();
//        Car car1 = new Car("su1");
//        car1.move(5);
//        carList.add(car1);
//        Car car2 = new Car("su2");
//        car2.move(5);
//        carList.add(car2);
//        Car car3 = new Car("su3");
//        carList.add(car3);
//
//        cars = new Cars(carList);
//    }

    @Test
    void createWithString() {
        Cars carsWithString = new Cars("su1,su2,su3");
        List<Car> carList = carsWithString.getCars();

        assertThat(carList.size()).isEqualTo(3);
        assertThat(carList).contains(new Car("su1"));
        assertThat(carList).contains(new Car("su2"));
        assertThat(carList).contains(new Car("su3"));
    }

    @Test
    void createWithCarList() {
        List<Car> carList = new LinkedList<>();
        Car car1 = new Car("su1");
        carList.add(car1);
        Car car2 = new Car("su2");
        carList.add(car2);
        Car car3 = new Car("su3");
        carList.add(car3);

        Cars cars2 = new Cars(carList);
        List<Car> result = cars2.getCars();
        System.out.println(result.size());
        assertThat(result.size()).isEqualTo(3);
        assertThat(result).contains(new Car("su1"));
        assertThat(result).contains(new Car("su2"));
        assertThat(result).contains(new Car("su3"));
    }

    @Test
    void 우승자() {
        List<Car> carList = new LinkedList<>();
        Car car1 = new Car("su1");
        car1.move(5);
        carList.add(car1);
        Car car2 = new Car("su2");
        car2.move(5);
        carList.add(car2);
        Car car3 = new Car("su3");
        carList.add(car3);

        Cars cars = new Cars(carList);
        assertThat(cars.winners()).isEqualTo("su1, su2");
    }

    @Test
    void topPosition() {

        List<Car> carList = new LinkedList<>();
        Car car1 = new Car("su1");
        car1.move(5);
        carList.add(car1);
        Car car2 = new Car("su2");
        car2.move(5);
        carList.add(car2);
        Car car3 = new Car("su3");
        carList.add(car3);
        Cars cars = new Cars(carList);

        assertThat(cars.getTopPosition(carList)).isEqualTo(1);

    }
}