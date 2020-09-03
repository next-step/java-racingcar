package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("carCounts 만큼, position 0인 cars create")
    @Test
    void carsReadyForRacingGameTest() {
        RacingGame game = new RacingGame("pobi,crong", 3);
        Cars newCars = game.getCars();
        assertThat(newCars.getCars()).hasSize(2);
        assertThat(newCars.getCars().get(0).getPosition()).isEqualTo(0);
        assertThat(newCars.getCars().get(1).getPosition()).isEqualTo(0);
    }

    @Test
    void allRaceRecordTest() {
        RacingGame game = new RacingGame("pobi,crong", 3);
        assertThat(game.recordAllRacing()).hasSize(3);
        assertThat(game.recordAllRacing().get(0)).hasSize(2);
        assertThat(game.recordAllRacing().get(1).get(0).getCarName()).isEqualTo("pobi");
        assertThat(game.recordAllRacing().get(0).get(0).getPosition()).isLessThanOrEqualTo(6);
        assertThat(game.recordAllRacing().get(1).get(0).getPosition()).isLessThanOrEqualTo(6);
//        assertThat(game.recordAllRacing().get(1).get(0).getPosition()).isLessThanOrEqualTo(10);
    }
}
