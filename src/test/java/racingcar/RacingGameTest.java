package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domains.RacingCars;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void initTest() {
        racingGame = new RacingGame();
    }

    @ParameterizedTest
    @CsvSource(value = {"green,red,blue:3",
                        "car1,car2,car3,car4:4",
                        "car:1"}, delimiter = ':')
    void initiateCarsTest(String carNames, int carNumTotal) {
        RacingCars racingCars = racingGame.initiateCars(carNames);

        assertThat(racingCars.size()).isEqualTo(carNumTotal);
    }

    @Test
    void startRaceTest() {
        //TODO. 테스트 영향 안받도록 처리하기
        RacingCars racingCars = racingGame.initiateCars("yellow,red,blue");

//        List<RacingResult> racingResults = racingGame.startRace(racingCars, racingCars.size());

//        assertThat(racingResults.size()).isEqualTo(racingCars.size());
    }

}