package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RaceResultsTest {

    @Test
    void 모든_레이스의_결과를_저장한다() {
        RaceResult firstRaceResult = new RaceResult(
            Arrays.asList(new Car("jiin", 0), new Car("leah", 1), new Car("sam", 1))
        );
        RaceResult secondRaceResult = new RaceResult(
            Arrays.asList(new Car("jiin", 1), new Car("leah", 2), new Car("sam", 1))
        );
        RaceResult thirdRaceResult = new RaceResult(
            Arrays.asList(new Car("jiin", 1), new Car("leah", 3), new Car("sam", 2))
        );
        RaceResults raceResults = new RaceResults(
            Arrays.asList(firstRaceResult, secondRaceResult, thirdRaceResult));
        List<RaceResult> totalResults = raceResults.getRaceResults();
        assertThat(totalResults.size()).isEqualTo(3);
        assertThat(totalResults.get(0).equals(firstRaceResult.getRaceResultByRound()));
    }

    @Test
    void 우승자를_찾는다() {
        RaceResult firstRaceResult = new RaceResult(
            Arrays.asList(new Car("jiin", 0), new Car("leah", 1), new Car("sam", 1))
        );
        RaceResult secondRaceResult = new RaceResult(
            Arrays.asList(new Car("jiin", 1), new Car("leah", 2), new Car("sam", 1))
        );
        RaceResult thirdRaceResult = new RaceResult(
            Arrays.asList(new Car("jiin", 1), new Car("leah", 3), new Car("sam", 2))
        );
        RaceResults raceResults = new RaceResults(
            Arrays.asList(firstRaceResult, secondRaceResult, thirdRaceResult));
        assertThat(raceResults.findWinners()).containsExactly("leah");
    }
}