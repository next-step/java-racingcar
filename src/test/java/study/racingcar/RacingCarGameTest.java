package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.RacingCar;
import study.racingcar.domain.RacingCarGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    private RacingCar lastRacingCar;
    private RacingCar firstWinnerRacingCar;
    private RacingCar secondWinnerRacingCar;

    @BeforeEach
    void setup(){
        firstWinnerRacingCar = new RacingCar(5, "win1");
        secondWinnerRacingCar = new RacingCar(5, "win2");
        lastRacingCar = new RacingCar(0, "last");
    }

    @Test
    @DisplayName("우승자 선정")
    void getWinner(){
        List<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(lastRacingCar);
        racingCarList.add(firstWinnerRacingCar);
        racingCarList.add(secondWinnerRacingCar);

        RacingCarGame racingCarGame = new RacingCarGame(racingCarList, 5);

        assertThat(racingCarGame.getWinnerNames(racingCarList)).contains("win1", "win2");
        assertThat(String.join(", ", racingCarGame.getWinnerNames(racingCarList))).isEqualTo("win1, win2");
    }

}
