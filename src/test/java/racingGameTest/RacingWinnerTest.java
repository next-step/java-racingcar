package racingGameTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Car;
import racingGame.domain.RacingGame;
import racingGame.domain.Winner;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingWinnerTest {
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
        assertThat(new Winner(racingCars).findWinnerNames()).containsExactly("pobi", "honux");
    }
}
