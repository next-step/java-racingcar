package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    void createCarsbyCarCounts() {
        RacingGame game = new RacingGame(2, new RacingCounts(3));
        assertThat(game.createCars(2).getCars()).hasSize(2);
    }

}
