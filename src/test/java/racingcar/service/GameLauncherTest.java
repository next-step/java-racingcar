package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.strategy.RandomMoveStrategy;

class GameLauncherTest {

    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void 모든차앞으로전진(boolean moveNum, int expectedPosition) {
        // given
        RacingGame racingGame = new RacingGame(Arrays.asList("qwe", "asdf", "zx"), 3,
            () -> moveNum);

        // when
        racingGame.race();

        // then
        List<Car> racingCars = racingGame.getCars().getCars();
        assertThat(racingCars.get(0).getPosition()).isEqualTo(expectedPosition);
        assertThat(racingCars.get(1).getPosition()).isEqualTo(expectedPosition);
        assertThat(racingCars.get(2).getPosition()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:true", "0:false"}, delimiter = ':')
    void 진행가능여부조회(int tryRaceCount, boolean isOngoing) {
        // given
        RacingGame racingGame = new RacingGame(Arrays.asList("qwe", "asdf", "zx"), tryRaceCount,
            new RandomMoveStrategy());

        // then
        assertThat(racingGame.isOngoing()).isEqualTo(isOngoing);
    }
}
