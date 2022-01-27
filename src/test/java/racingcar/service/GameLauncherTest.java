package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

class GameLauncherTest {

    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void 모든차앞으로전진(boolean moveNum, int expectedPosition) {
        // given
        GameLauncher gameLauncher = new GameLauncher(Arrays.asList("qwe", "asdf", "zx"), 3);

        // when
        gameLauncher.race(()->moveNum);

        // then
        List<Car> racingCars = gameLauncher.getCars().getCars();
        assertThat(racingCars.get(0).getPosition()).isEqualTo(expectedPosition);
        assertThat(racingCars.get(1).getPosition()).isEqualTo(expectedPosition);
        assertThat(racingCars.get(2).getPosition()).isEqualTo(expectedPosition);
    }
}
