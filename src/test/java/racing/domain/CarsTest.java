package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차가 입력받은 댓수만큼 생긴다")
    void createCars() {
        String[] names = new String[]{"pobi", "crong", "honux"};
        Cars cars = Cars.create(names);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 위치 최댓값을 구할 수 있다")
    void find_winner() {
        Car car1 = new Car("pobi", 3);
        Car car2 = new Car("crong", 5);
        Car car3 = new Car("honux", 2);
        List<Car> carList = List.of(car1, car2, car3);
        Cars cars = Cars.create(carList);
        assertThat(cars.getMaxPosition()).isEqualTo(5);
    }
}
