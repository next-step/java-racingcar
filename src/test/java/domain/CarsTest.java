package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("자동차 리스트 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void moveCarsTest(boolean movable, int position) {
        Car car1 = new Car("user1");
        Car car2 = new Car("user2");
        Car car3 = new Car("user3");

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        assertThat(cars.moveCars(() -> movable))
                .isEqualTo((Arrays.asList(
                        new Car("user1", position),
                        new Car("user2", position),
                        new Car("user3", position)
                )));
    }

    @DisplayName("자동차 리스트 중 우승자를 찾는 기능 테스트")
    @Test
    void findWinnersTest() {
        Car car1 = new Car("user1", 1);
        Car car2 = new Car("user2", 2);
        Car car3 = new Car("user3", 2);
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
        for (Car winner : cars.findWinners()) {
            System.out.println(winner.getName());
        }
        assertThat(cars.findWinners()).containsExactly(car2, car3);
    }
}