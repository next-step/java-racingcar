package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 시도횟수만큼_레이스를한다() {
        RacingGame racingGame = new RacingGame(
            new Cars(Arrays.asList(new Car("jiin"), new Car("leah"), new Car("sam"))), 3,
            new RandomStrategy());
        RaceResults raceResults = racingGame.startRace();
        assertThat(raceResults.getRaceResults().size()).isEqualTo(3);
    }

    @Test
    void 레이스_후_위치_확인() {
        RacingGame racingGame = new RacingGame(
            new Cars(Arrays.asList(new Car("jiin"), new Car("leah"), new Car("sam"))), 3,
            () -> true);
        RaceResults raceResults = racingGame.startRace();
        List<Car> lastRaceResult = raceResults.getRaceResults().get(2);
        assertThat(lastRaceResult.get(0).getPosition()).isEqualTo(3);
    }
}