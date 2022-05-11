package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinnerTest {
    List<RacingCar> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new RacingCar("차1"));
        cars.add(new RacingCar("차2"));
        cars.add(new RacingCar("차3"));
    }

    @Test
    void 우승자_테스트() {
        cars.get(1).move(6);
        RacingCars racingCars = new RacingCars(cars);

        List<RacingCar> winners = new ArrayList<>();
        winners.add(new RacingCar("차2", 1));

        assertThat(Winners.findWinners(racingCars)).isEqualTo(winners);
    }
}
