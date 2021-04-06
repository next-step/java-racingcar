package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.*;

import java.util.Arrays;
import java.util.List;

public class RacingGameTest {

    @DisplayName("경기를 요청한 횟수와 진행한 횟수를 확인해볼 수 있는 내용")
    @ParameterizedTest
    @CsvSource(value = {"4", "3", "2"}, delimiter = ':')
    void cars_can_moves_given_number_test(int givenRound) {

        //given
        RacingCar pobiCar = new RacingCar("pobi", 0);

        //when
        RacingGame racingGame = new RacingGame();
        List<RacingCar> list = Arrays.asList(pobiCar);
        racingGame.startRace(list, givenRound);

        //then
        assertThat(racingGame.currentRound).isEqualTo(givenRound);

    }



    @DisplayName("우승자가 1명일 경우와 주어진 라운드가 1인 경우 ")
    @Test
    void winner_one() {

        RacingCar pobiCar = new RacingCar("pobi", 0);

        pobiCar.move(5);
        List<RacingCar> winnerList = Arrays.asList(pobiCar);

        assertThat(new Winner().findWinners(winnerList)).contains(pobiCar);


    }

    @DisplayName("우승자가 2명일 경우와 주어진 라운드가 3인 경우")
    @Test
    void winner_two() {

        RacingCar pobiCar = new RacingCar("pobi", 0);
        RacingCar crongCar = new RacingCar("crong", 0);

        for (int i = 0; i < 3; i++) {
            pobiCar.move(5);
            crongCar.move(5);
        }

        List<RacingCar> winnerList = Arrays.asList(pobiCar, crongCar);
        assertThat(new Winner().findWinners(winnerList)).contains(pobiCar, crongCar);
    }

}
