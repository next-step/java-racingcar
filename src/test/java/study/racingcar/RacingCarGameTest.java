package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.racingcar.entity.RacingCar;
import study.racingcar.service.RacingCarGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    private RacingCarGame racingCarGame;
    private RacingCar lastRacingCar;
    private RacingCar firstWinnerRacingCar;
    private RacingCar secondWinnerRacingCar;

    @BeforeEach
    void setup(){
        racingCarGame = new RacingCarGame();
        firstWinnerRacingCar = new RacingCar(5, "win1");
        secondWinnerRacingCar = new RacingCar(5, "win2");
        lastRacingCar = new RacingCar(0, "last");
    }

    @ParameterizedTest
    @CsvSource(value = {"test:true", "testC:true", "testCa:false", "testCar:false"}, delimiter = ':')
    @DisplayName("자동차 이름 5자 제한")
    void racingCarNameValidCheck(String carName, boolean expected){
        assertThat(racingCarGame.carNameValidCheck(carName)).isEqualTo(expected);
    }

    @Test
    @DisplayName("우승자 선정")
    void getWinner(){
        List<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(lastRacingCar);
        racingCarList.add(firstWinnerRacingCar);
        racingCarList.add(secondWinnerRacingCar);

        assertThat(racingCarGame.getWinnerNames(racingCarList)).contains("win1", "win2");
        assertThat(String.join(", ", racingCarGame.getWinnerNames(racingCarList))).isEqualTo("win1, win2");
    }

}
