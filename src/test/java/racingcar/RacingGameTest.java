package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.utils.GameSet;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("주어진 횟수 동안 pobi, crong, honux의 자동차는 전진 또는 멈출 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi:1", "crong:2 ", "honux:5"}, delimiter = ':')
    void cars_can_moves_given_number_test(String owners, int count) {

        GameSet gameSet = new GameSet(owners, count);
        RacingGame racingGame = new RacingGame();

        List<RacingCar> list = racingGame.settingRacingCars(gameSet.getOwners());
        racingGame.gameStart(list, count);

    }


    @DisplayName("우승자가 1명일 경우와 주어진 라운드가 1인 경우 ")
    @Test
    void winner_one() {

        GameSet gameSet = new GameSet("pobi", 1);
        RacingGame racingGame = new RacingGame();

        List<RacingCar> list = racingGame.settingRacingCars(gameSet.getOwners());

        RacingCar pobiCar = list.get(0);
        pobiCar.move(5);

        List<RacingCar> winnerList = Arrays.asList(pobiCar);

        RacingCars racingCars = new RacingCars(winnerList);

        assertThat(racingCars.findWinners(winnerList)).contains(pobiCar);
        

    }

    @DisplayName("우승자가 2명일 경우와 주어진 라운드가 1인 경우")
    @Test
    void winner_two() {

        GameSet gameSet = new GameSet("pobi,crong", 1);
        RacingGame racingGame = new RacingGame();

        List<RacingCar> list = racingGame.settingRacingCars(gameSet.getOwners());

        RacingCar pobiCar = list.get(0);
        RacingCar crongCar = list.get(1);

        pobiCar.move(5);
        crongCar.move(5);

        List<RacingCar> winnerList = Arrays.asList(pobiCar, crongCar);

        assertThat(1).isEqualTo(pobiCar.getLocation());
        assertThat(1).isEqualTo(crongCar.getLocation());

        RacingCars racingCars = new RacingCars(winnerList);

        assertThat(racingCars.findWinners(winnerList)).contains(pobiCar, crongCar);
    }

}
