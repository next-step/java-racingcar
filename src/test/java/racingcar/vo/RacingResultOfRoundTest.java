package racingcar.vo;

import org.junit.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingResultOfRoundTest {

    @Test
    public void 우승자_구하기() {
        // given
        Car winner1 = new Car("winner1");
        Car winner2 = new Car("winner2");
        Car loser = new Car("loser");

        int value = Car.MOVE_THRESHOLD + 1;
        winner1.goWhenGreaterThanThreshold(value);
        winner2.goWhenGreaterThanThreshold(value);

        List<Car> cars = Arrays.asList(winner1, winner2, loser);
        int round = 5;
        RacingResultOfRound racingResult = new RacingResultOfRound(cars, round);

        // when
        List<Car> winners = racingResult.getWinners();

        // then
        assertThat(winners).containsExactly(winner1, winner2);
    }
}
