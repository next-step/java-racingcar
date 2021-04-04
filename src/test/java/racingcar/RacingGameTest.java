package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.command.NumberType;
import racingcar.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("주어진 횟수 동안 pobi, crong, honux의 자동차는 전진할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi:1", "crong:3 ", "honux:5"}, delimiter = ':')
    void cars_can_moves_given_number_test(String owners, int count) {

        RacingCar racingCar = new RacingCar(owners, NumberType.ZERO.value());
        for (int i = 0; i < count; i++) {
            racingCar.move(NumberType.FOUR.value());
        }

        assertThat(racingCar.getLocation()).isEqualTo(count);

    }


    @DisplayName("우승자가 1명일 경우와 주어진 라운드가 1인 경우 ")
    @Test
    void winner_one() {

        RacingCar pobiCar = new RacingCar("pobi", NumberType.ZERO.value());

        pobiCar.move(NumberType.FIVE.value());
        List<RacingCar> winnerList = Arrays.asList(pobiCar);

        assertThat(new Winner().findWinners(winnerList)).contains(pobiCar);


    }

    @DisplayName("우승자가 2명일 경우와 주어진 라운드가 3인 경우")
    @Test
    void winner_two() {

        RacingCar pobiCar = new RacingCar("pobi", NumberType.ZERO.value());
        RacingCar crongCar = new RacingCar("crong", NumberType.ZERO.value());

        for (int i = 0; i < 3; i++) {
            pobiCar.move(NumberType.FIVE.value());
            crongCar.move(NumberType.FIVE.value());
        }

        List<RacingCar> winnerList = Arrays.asList(pobiCar, crongCar);
        assertThat(new Winner().findWinners(winnerList)).contains(pobiCar, crongCar);
    }

}
