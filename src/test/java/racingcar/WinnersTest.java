package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("우승자를 구할 수 있다. ")
    @Test
    void testGetWinner() {
        Car car1 = new Car("car1", 4);
        Car car2 = new Car("car2", 2);
        Car car3 = new Car("car3", 3);
        List<Car> cars = Arrays.asList(car1, car2, car3);

        List<Car> winners = Winners.findWinners(cars);

        assertThat(winners).hasSize(1);
        assertThat(winners).contains(car1);
    }
}
