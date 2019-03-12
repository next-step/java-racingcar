package racingcar.domain;

import org.junit.Test;
import racingcar.vo.RacingResultOfRound;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameJudgeTest {

    @Test
    public void 우승자_확인() {
        Car winner1 = new Car("winner1", 1);
        Car winner2 = new Car("winner2", 1);
        Car loser = new Car("loser");

        List<Car> carsOfRound = Arrays.asList(winner1, winner2, loser);
        int round = 5;
        RacingResultOfRound racingResultOfRound = new RacingResultOfRound(carsOfRound, round);

        RacingGameJudge racingGameJudge = new RacingGameJudge();
        List<Car> winners = racingGameJudge.getWinners(racingResultOfRound);

        assertThat(winners)
                .containsExactly(winner1, winner2);
    }
}
