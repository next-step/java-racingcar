package view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.RacingCar;
import racing.RacingCars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultViewTest {

    @ParameterizedTest
    @CsvSource(value = {"1;root;root : -", "5;trevi;trevi : -----"}, delimiter = ';')
    void carResultTest(int position, String name, String result) {
        final RacingCar car = RacingCar.init(position, name);
        assertThat(RacingResultView.carResult(car)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"root;trevi;root, trevi가 최종 우승했습니다."}, delimiter = ';')
    void winnersResultTest(String name1, String name2, String result) {
        final RacingCar winner1 = RacingCar.init(name1);
        final RacingCar winner2 = RacingCar.init(name2);

        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(winner1);
        racingCars.add(winner2);

        final RacingCars winners = RacingCars.init(racingCars);
        assertThat(RacingResultView.winnersResult(winners)).isEqualTo(result);
    }
}
