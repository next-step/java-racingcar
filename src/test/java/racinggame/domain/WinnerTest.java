package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    private List<Car> racingCars;

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
        List<Car> winner = new ArrayList<>();
        winner.add(racingCars.get(0));
        winner.add(racingCars.get(2));

        assertThat(new Winner(racingCars).findWinnerNames()).containsExactlyInAnyOrderElementsOf(winner);
    }
}
