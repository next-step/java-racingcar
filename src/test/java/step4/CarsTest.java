package step4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void 우승자_찾기() {
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(2);

        List<Car> carList = List.of(car1, car2, car3);
        Cars cars = new Cars(carList, () -> true);

        assertThat(cars.getWinners()).containsExactly(car2, car3);
    }
}