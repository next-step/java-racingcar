package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("carCounts 만큼, position 0인 cars create")
    @Test
    void carsReadyForRacingGameTest() {
        RacingGame game = new RacingGame("pobi,honux", 4);
        List<Car> newCars = game.getCars();

        assertThat(newCars).hasSize(2);
        assertThat(newCars.get(0).getPosition()).isEqualTo(0);
        assertThat(newCars.get(1).getPosition()).isEqualTo(0);
    }

    @Test
    void allRaceResultsTest() {
        RacingGame game = new RacingGame("pobi,crong,honux", 3);
        assertThat(game.getRacingRecordList()).hasSize(0);
        game.start();

        assertThat(game.getRacingRecordList()).hasSize(3);
        assertThat(game.getRacingRecordList().get(0).getRacingRecord().get("pobi")).isLessThanOrEqualTo(1);
        assertThat(game.getRacingRecordList().get(2).getRacingRecord().get("pobi")).isNotEqualTo(
                game.getRacingRecordList( ).get(0).getRacingRecord().get("pobi"));

    }
}
