package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultTest {
    @DisplayName("우승자는 두명 이상일 수 있다.")
    @Test
    void winnerCanOverTwo() {
        RacingGameResult racingGameResult = new RacingGameResult();
        Cars cars = new Cars();
        cars.add(new Car("luvram", 3));
        cars.add(new Car("boram", 2));
        cars.add(new Car("rambo", 3));

        racingGameResult.addGameEvent(cars);
        Cars winners = racingGameResult.getWinners();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.stream().map(Car::getName)).contains("luvram", "rambo");
    }
}
