package racingcar.domain;

import org.junit.Test;
import racingcar.vo.RacingResultOfRound;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameJudgeTest {

    @Test
    public void 우승자_확인() {
        int value = Car.MOVE_THRESHOLD + 1;

        Car winner1 = new Car("winner1");
        Car winner2 = new Car("winner2");
        Car loser = new Car("loser");

        winner1.goWhenGreaterThanThreshold(value);
        winner2.goWhenGreaterThanThreshold(value);

        List<Car> carsOfRound = Arrays.asList(winner1, winner2, loser);
        int round = 5;
        RacingResultOfRound racingResultOfRound = new RacingResultOfRound(carsOfRound, round);

        RacingGameJudge racingGameJudge = new RacingGameJudge();
        List<Car> winners = racingGameJudge.getWinners(racingResultOfRound);

        assertThat(winners)
                .containsExactly(winner1, winner2);
    }
}
