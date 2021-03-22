package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("주어진 횟수 동안 pobi, crong, honux의 자동차는 전진 또는 멈출 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi:1", "crong:2 ", "honux:5"}, delimiter = ':')
    void cars_can_moves_given_number_test(String owners, int count) {

        GameSet gameSet = new GameSet(owners, count);
        RacingGame racingGame = new RacingGame(gameSet);

        List<RacingCar> list = racingGame.settingRacingCars(gameSet.getOwners());
        racingGame.gameStart(list, count);

    }


    @DisplayName("우승자가 1명일 경우와 주어진 라운드가 1인 경우 ")
    @Test
    void winner_one() {

        GameSet gameSet = new GameSet("pobi", 1);
        RacingGame racingGame = new RacingGame(gameSet);

        List<RacingCar> list = racingGame.settingRacingCars(gameSet.getOwners());

        RacingCar pobiCar = list.get(0);
        pobiCar.canGo(5);

        System.out.println(racingGame.getWinners(list));

    }

    @DisplayName("우승자가 2명일 경우와 주어진 라운드가 1인 경우")
    @Test
    void winner_two() {

        GameSet gameSet = new GameSet("pobi,crong", 1);
        RacingGame racingGame = new RacingGame(gameSet);

        List<RacingCar> list = racingGame.settingRacingCars(gameSet.getOwners());

        RacingCar pobiCar = list.get(0);
        RacingCar crongCar = list.get(1);

        pobiCar.canGo(5);
        crongCar.canGo(5);

        assertThat(1).isEqualTo(pobiCar.getCarLocation().length());
        assertThat(1).isEqualTo(crongCar.getCarLocation().length());

        assertThat(racingGame.getWinners(list)).contains("pobi,crong");
    }

}
