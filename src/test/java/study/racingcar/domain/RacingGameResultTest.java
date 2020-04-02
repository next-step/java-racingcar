package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultTest {
    @DisplayName("우승자는 두명 이상일 수 있다.")
    @Test
    void winnerCanOverTwo() {
        Cars cars = new Cars();
        cars.add(new Car("luvram", 3), new Car("boram", 2),
                new Car("rambo", 3));
        List<Cars> gameEventList = new ArrayList(Arrays.asList(cars));

        RacingGameResult racingGameResult = new RacingGameResult(gameEventList);
        racingGameResult.addGameEvent(cars);
        Cars winners = racingGameResult.getWinners();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.stream().map(Car::getName))
                .contains("luvram", "rambo");
    }
}
