package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGamePrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"root;5;trevi;1;root", "root;1;trevi;5;trevi", "root;5;trevi;5;root, trevi"}, delimiter = ';')
    void getWinnersTest(String name1, int position1, String name2, int position2, String result) {

        // given
        RacingCar car1 = RacingCar.init(position1, name1);
        RacingCar car2 = RacingCar.init(position2, name2);

        List<RacingCar> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        final RacingCars cars = RacingCars.init(carList);

        List<RacingCars> carsList = new ArrayList<>();
        carsList.add(cars);

        // when
        final RacingGamePrize racingGamePrize = RacingGamePrize.init(carsList);
        final RacingCars winners = racingGamePrize.getWinners();

        // then
        assertThat(winners.getNames()).isEqualTo(result);
    }
}
