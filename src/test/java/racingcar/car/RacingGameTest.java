package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.AlwaysMoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("우승자는 여러명일 수 있다.")
    @Test
    void raceWinners() {
        RacingGame racingGame = new RacingGame(Cars.of("pobi,crong,honux"));
        racingGame.race(new AlwaysMoveStrategy());
        List<Car> winners = racingGame.getRaceWinners();
        assertThat(winners).hasSize(3);
    }

}