package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RaceResultsTest {

    @Test
    void 모든_레이스의_결과를_저장한다() {
        List<Car> firstRaceResult =
            Arrays.asList(new Car("jiin", 0), new Car("leah", 1), new Car("sam", 1));
        List<Car> secondRaceResult =
            Arrays.asList(new Car("jiin", 1), new Car("leah", 2), new Car("sam", 1));
        List<Car> thirdRaceResult =
            Arrays.asList(new Car("jiin", 1), new Car("leah", 3), new Car("sam", 2));
        RaceResults raceResults = new RaceResults(
            Arrays.asList(firstRaceResult, secondRaceResult, thirdRaceResult));
        List<List<Car>> totalResults = raceResults.getRaceResults();
        assertThat(totalResults.size()).isEqualTo(3);
        assertThat(totalResults.get(0).get(0).getPosition()).isEqualTo(0);
        assertThat(totalResults.get(1).get(0).getPosition()).isEqualTo(1);
        assertThat(totalResults.get(2).get(0).getPosition()).isEqualTo(1);
    }

    @Test
    void 우승자를_찾는다() {
        List<Car> firstRaceResult =
            Arrays.asList(new Car("jiin", 0), new Car("leah", 1), new Car("sam", 1));
        List<Car> secondRaceResult =
            Arrays.asList(new Car("jiin", 1), new Car("leah", 2), new Car("sam", 1));
        List<Car> thirdRaceResult =
            Arrays.asList(new Car("jiin", 1), new Car("leah", 3), new Car("sam", 2));
        RaceResults raceResults = new RaceResults(
            Arrays.asList(firstRaceResult, secondRaceResult, thirdRaceResult));
        assertThat(raceResults.findWinners()).containsExactly("leah");
    }
}