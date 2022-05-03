package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {
    @DisplayName("우승 자동차 확인")
    @Test
    void findWinners() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1", 1));
        cars.add(new Car("car2", 2));
        cars.add(new Car("car3", 3));

        List<Car> winners = Winners.findWinners(cars);
        assertThat(winners).contains(new Car("car3", 3));
    }
}
