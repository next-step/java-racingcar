package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void 모든차앞으로전진(boolean moveNum, int expectedPosition) {
        // given
        Cars cars = Cars.of(Arrays.asList("qwe", "asdf", "zx"));

        // when
        cars.moveAll(()->moveNum);

        // then
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(expectedPosition);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(expectedPosition);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void 우승자선별() {
        // given
        List<Car> carsInit = new ArrayList<>();
        carsInit.add(new RacingCar("aaa", 0));
        carsInit.add(new RacingCar("bbb", 2));
        carsInit.add(new RacingCar("ccc", 2));
        Cars cars = new Cars(carsInit);

        // when
        List<Car> winnerList = cars.getWinners();

        // then
        assertThat(winnerList.size()).isEqualTo(2);
        assertThat(winnerList.get(0).getName()).isEqualTo("bbb");
        assertThat(winnerList.get(1).getName()).isEqualTo("ccc");
    }
}
