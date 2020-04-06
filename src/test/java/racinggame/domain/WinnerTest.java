package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Winner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    List<Car> racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new ArrayList<>();
        Car car1 = new Car("pobi", 5);
        Car car2 = new Car("crong", 4);
        Car car3 = new Car("honux", 5);

        racingCars.add(car1);
        racingCars.add(car2);
        racingCars.add(car3);
    }

    @Test
    void findWinnerNamesTest() {
        assertThat(new Winner(racingCars).findWinnerNames()).hasSize(2);
        assertThat(new Winner(racingCars).findWinnerNames()).containsExactly(racingCars.get(0), racingCars.get(2));
    }
}
