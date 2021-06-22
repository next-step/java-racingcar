package carracing;

import carracing.model.Car;
import carracing.model.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList(new Car("aCar", 0), new Car("bCar", 0),
                new Car("cCar", 0)));
    }

    @DisplayName("자동차 경주의 우승자는 `위치`값이 가장 높은 자동차이다.")
    @Test
    void findWinnerTest() {
        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(1).move(() -> false);
        cars.getCars().get(2).move(() -> false);
        assertThat(cars.makeWinners()).contains("aCar");
    }

    @DisplayName("자동차 경주는 공동 우승자일 수 있다.")
    @Test
    void findTieWinnerTest() {
        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(1).move(() -> true);
        cars.getCars().get(2).move(() -> false);
        assertThat(cars.makeWinners()).contains("aCar").contains("bCar");
        assertThat(cars.makeWinners()).isNotEqualTo("cCar");
    }

    @DisplayName("자동차 경주는 공동 우승자일 수 있다.")
    @Test
    void findTieWinnerTest2() {
        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(1).move(() -> true);
        cars.getCars().get(2).move(() -> true);
        assertThat(cars.makeWinners()).contains("aCar").contains("bCar").contains("cCar");
    }
}
