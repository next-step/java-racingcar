package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RaceWinnerTest {

    @Test
    void 레이스_공동_우승자() {
        List<LapResult> lapResults = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("1"));
        carList.add(new Car("2"));
        lapResults.add(new LapResult(carList));

        carList.get(0).move();
        carList.get(1).move();
        lapResults.add(new LapResult(carList));

        assertAll(
            () -> assertThat(RaceWinner.raceWinner(new RaceResults(lapResults))).hasSize(2),
            () -> assertThat(RaceWinner.raceWinner(new RaceResults(lapResults))).contains("1", "2")
        );
    }

    @Test
    void 레이스_단독_우승자() {
        List<LapResult> lapResults = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("1"));
        carList.add(new Car("2"));
        lapResults.add(new LapResult(carList));

        carList.get(0).move();
        lapResults.add(new LapResult(carList));

        assertAll(
            () -> assertThat(RaceWinner.raceWinner(new RaceResults(lapResults))).hasSize(1),
            () -> assertThat(RaceWinner.raceWinner(new RaceResults(lapResults))).containsOnly("1")
        );
    }

}
