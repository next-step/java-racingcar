package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @ParameterizedTest
    @ValueSource(strings = {"소나", "탐켄치"})
    @DisplayName("입력한 이름을 가진 Cars 생성")
    void generate_cars_with_name(String name) {
        String testNames = "소나,탐켄치";
        Cars generateCars = cars.generateCarsWithName(testNames);
        assertThat(generateCars).isEqualTo(new Cars(Arrays.asList(new Car("소나"), new Car("탐켄치"))));
    }

    @Test
    @DisplayName("우승자동차 한대인 경우")
    void winner_car_test() {
        Car first = new Car("소나", 2);
        Car second = new Car("제드", 1);
        Cars cars = new Cars(Arrays.asList(first, second));

        Cars winner = cars.findWinner();
        assertThat(winner).isEqualTo(new Cars(Arrays.asList(first)));
    }

    @Test
    @DisplayName("우승자동차 여러대인 경우")
    void multi_winner_cars_test() {
        Car first = new Car("소나", 5);
        Car second = new Car("제드", 4);
        Car third = new Car("가렌", 5);
        Cars cars = new Cars(Arrays.asList(first, second, third));

        Cars winner = cars.findWinner();

        assertThat(winner).isEqualTo(new Cars(Arrays.asList(first, third)));
    }
}