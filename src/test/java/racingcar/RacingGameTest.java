package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domains.RacingCar;
import racingcar.domains.RacingCars;
import racingcar.domains.RacingResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void initTest() {
        racingGame = new RacingGame();
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 11, 2})
    void initiateCarsTest(int carNumTotal) {
        RacingCars racingCars = racingGame.initiateCars(carNumTotal);

        assertThat(racingCars.size()).isEqualTo(carNumTotal);
//        assertThat(racingCars.get(0)).isInstanceOf(RacingCar.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:3", "11:10", "2:5"}, delimiter = ':')
    void startRaceTest(int carNumTotal, int roundNumTotal) {
        RacingCars racingCars = racingGame.initiateCars(carNumTotal);

        List<RacingResult> racingResults =  racingGame.startRace(racingCars, roundNumTotal);

        assertThat(racingResults.size()).isEqualTo(roundNumTotal);
    }

}