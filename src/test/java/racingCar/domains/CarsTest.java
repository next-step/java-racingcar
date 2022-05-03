package racingCar.domains;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private List<Car> carList;

    @BeforeEach
    void setup() {
        carList = new ArrayList<>();
    }

    @DisplayName("우승자는 position이 가장 큰 자동차들이다.")
    @Test
    void findWinners() {
        carList.add(new Car("a", 2));
        carList.add(new Car("b"));
        carList.add(new Car("c", 2));
        Cars cars = new Cars(carList);

        assertThat(cars.findWinners()).containsExactlyInAnyOrder(new Car("c", 2), new Car("a", 2));
    }

    @DisplayName("각 자동차는 조건(랜덤값)이 4이상인 경우 전진한다.")
    @Test
    void moveWhenMoreThanFour() {
        carList.add(new Car("a", new FixedNumberGenerator(3)));
        carList.add(new Car("b", new FixedNumberGenerator(4)));
        Cars cars = new Cars(carList);
        cars.move();

        assertThat(cars.getCars()).containsExactlyInAnyOrder(new Car("a", 0), new Car("b", 1));
    }
}
