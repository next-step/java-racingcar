package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Location;
import racingcar.domain.Owner;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("주어진 횟수 동안 pobi, crong, honux의 자동차는 전진 또는 멈출 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi:1", "crong:3 ", "honux:5"}, delimiter = ':')
    void cars_can_moves_given_number_test(String owners, int count) {

        RacingCar racingCar = new RacingCar(new Owner(owners), new Location(0));
        for (int i = 0; i < count; i++) {
            racingCar.move(4);
        }

        assertThat(racingCar.getLocation()).isEqualTo(count);

    }


    @DisplayName("우승자가 1명일 경우와 주어진 라운드가 1인 경우 ")
    @Test
    void winner_one() {

        RacingCar pobiCar = new RacingCar(new Owner("pobi"), new Location(0));

        pobiCar.move(5);
        List<RacingCar> winnerList = Arrays.asList(pobiCar);

        RacingCars racingCars = new RacingCars(winnerList);
        assertThat(racingCars.findWinners(winnerList)).contains(pobiCar);


    }

    @DisplayName("우승자가 2명일 경우와 주어진 라운드가 3인 경우")
    @Test
    void winner_two() {

        RacingCar pobiCar = new RacingCar(new Owner("pobi"), new Location(0));
        RacingCar crongCar = new RacingCar(new Owner("crong"), new Location(0));

        for (int i = 0; i < 3; i++) {
            pobiCar.move(5);
            crongCar.move(5);
        }

        List<RacingCar> winnerList = Arrays.asList(pobiCar, crongCar);
        RacingCars racingCars = new RacingCars(winnerList);
        assertThat(racingCars.findWinners(winnerList)).contains(pobiCar, crongCar);
    }

}
