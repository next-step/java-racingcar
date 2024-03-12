package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"0:kim", "1:nick", "2:june"}, delimiter = ':')
    @DisplayName("자동차가 다같이 움직여 모두 승리")
    void Cars__ShouldWinAllDrivers(int index, String name) {
        // given
        String[] names = new String[]{"kim", "nick", "june"};
        CarMovementStrategy carMovementStrategy = () -> true;

        // when
        Cars cars = new Cars(names);
        cars.moveOrNot(carMovementStrategy);
        List<Car> winners = cars.getTheHighestScoreDrivers();

        // then
        assertThat(winners.get(index).getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차가 랜덤으로 움직여 최소한 1명의 승자가 존재")
    void Cars__ShouldWinAtLeastOneDriver() {
        // given
        String[] names = new String[]{"kim", "nick", "june"};
        CarMovementStrategy carMovementStrategy = new RandomMovementStrategy();

        // when
        Cars cars = new Cars(names);
        cars.moveOrNot(carMovementStrategy);
        List<Car> winners = cars.getTheHighestScoreDrivers();

        // then
        assertThat(winners.size()).isGreaterThan(0);
    }
}
