package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.OneOrZeroForwardCondition;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("carCounts 만큼, position 0인 cars create")
    @Test
    void createCarsbyCarCounts() {
        RacingGame game = new RacingGame(2, new RacingCounts(3));
        List<Car> newCars = game.createCars(2).getCars();
        assertThat(newCars).hasSize(2);
        assertThat(newCars.get(0).getPosition()).isEqualTo(0);
        assertThat(newCars.get(1).getPosition()).isEqualTo(0);
    }
}
