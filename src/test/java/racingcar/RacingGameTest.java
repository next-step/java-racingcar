package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setMaxElementsForPrinting;

public class RacingGameTest {

    @DisplayName("0~9까지 랜덤 출력")
    @Test
    void random_test() {
        System.out.println(RandomNumber.random());
    }


    @DisplayName("주어진 횟수 동안 pobi, crong, honux의 자동차는 전진 또는 멈출 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi:1", "crong:2 ", "honux:5"}, delimiter = ':')
    void cars_can_moves_given_number_test(String owners, int count) {

        GameSet gameSet = new GameSet(owners, count);
        RacingGame racingGame = new RacingGame(gameSet);

        List<RacingCar> list = racingGame.settingRacingCars(gameSet.getOwners());
        racingGame.gameStart(list, count);
        assertThat(owners).isEqualTo(gameSet.getOwners());
        assertThat(count).isEqualTo(gameSet.getGivenRound());

    }


    @DisplayName("우승자가 있을경우 - pobi")
    @Test
    void winner() {
        GameSet gameSet = new GameSet("pobi", 1);
        RacingGame racingGame = new RacingGame(gameSet);

        RacingCar racingCar = new RacingCar("pobi", null);
        racingCar.isGo(5);

        List<RacingCar> list = racingGame.settingRacingCars(gameSet.getOwners());
        racingGame.gameStart(list, 1);

        Winner winner = new Winner();
        String name = winner.whoisWin(list, gameSet);


        assertThat("pobi가 최종 우승했습니다.").isEqualTo(winner.showResult(name));
    }


    @DisplayName("우승자가 없을 경우")
    @Test
    void no_winner() {
        GameSet gameSet = new GameSet("pobi", 1);
        RacingGame racingGame = new RacingGame(gameSet);

        RacingCar racingCar = new RacingCar("pobi", null);

        List<RacingCar> list = racingGame.settingRacingCars(racingCar.getOwner());

        assertThat("").isEqualTo(new Winner().whoisWin(list, gameSet));

    }
}
