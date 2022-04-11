package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        RacingCar pobi = new RacingCar("pobi");
        RacingCar crong = new RacingCar("crong");
        RacingCar honux = new RacingCar("honux");

        pobi.moveOrStop(3);
        crong.moveOrStop(5);
        honux.moveOrStop(5);

        List<RacingCar> racingCars = Arrays.asList(pobi, crong, honux);
        racingGame = new RacingGame(racingCars);
    }

    @Test
    @DisplayName("경주에서 우승한 사람을 구하는 테스트")
    void winnerOfTheRace() {
        List<String> winners = racingGame.winnersOfTheRace();

        assertThat(winners).hasSize(2);
        assertThat(winners).contains("crong", "honux");
    }

}