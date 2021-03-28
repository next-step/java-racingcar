package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domains.RacingCar;
import racingcar.domains.RacingResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private RacingGame racingGame;
    private List<RacingCar> racingCars;

    @BeforeEach
    void initTest() {
        racingCars = new ArrayList<>();
        racingGame = new RacingGame();
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 11, 2})
    void initiateCarsTest(int carNumTotal) {
        racingGame.initiateCars(racingCars, carNumTotal);

        assertThat(racingCars.size()).isEqualTo(carNumTotal);
        assertThat(racingCars.get(0)).isInstanceOf(RacingCar.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 5})
    void startRaceTest(int roundNumTotal) {
        List<RacingResult> racingResults =  racingGame.startRace(racingCars, roundNumTotal);

        assertThat(racingResults.size()).isEqualTo(roundNumTotal);
    }

}